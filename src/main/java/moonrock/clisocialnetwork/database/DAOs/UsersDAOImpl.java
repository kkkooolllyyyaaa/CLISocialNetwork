package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;
import moonrock.clisocialnetwork.exceptions.DataExistException;
import moonrock.clisocialnetwork.exceptions.NoDataException;
import org.hibernate.Session;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UsersDAOImpl extends SessionUtility implements UsersDAO {

    @Override
    public List<User> getAll() {
        openTransactionSession();

        Session session = getSession();
        TypedQuery<User> query = session.createQuery("from User", User.class);
        List<User> userList = query.getResultList();

        closeTransactionSession();
        return userList;
    }

    @Override
    public boolean isExist(String username, String password) throws NoDataException {
        try {
            openTransactionSession();

            Session session = getSession();
            String sql = "SELECT * FROM users WHERE username = :username";
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();

            closeTransactionSession();
            return user != null && user.getPassword().equals(password);
        } catch (PersistenceException e) {
            throw new NoDataException("User is not exist");
        }
    }

    @Override
    public User getUserByUsername(String username) throws NoDataException {
        try {
            openTransactionSession();

            Session session = getSession();
            String sql = "SELECT * FROM users WHERE username = :username";

            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();

            closeTransactionSession();
            return user;
        } catch (PersistenceException e) {
            throw new NoDataException("There is no user with username: " + username);
        }
    }

    @Override
    public void addUser(User user) throws DataExistException {
        try {
            openTransactionSession();

            Session session = getSession();
            session.save(user);

            closeTransactionSession();
        } catch (Exception e) {
            throw new DataExistException("User with username: " + user + " already exists");
        }
    }

    @Override
    public void deleteUser(User user) throws NoDataException {
        try {
            openTransactionSession();

            Session session = getSession();
            session.remove(user);

            closeTransactionSession();
        } catch (Exception e) {
            throw new NoDataException("There is no user with this username and password");
        }
    }

    @Override
    public void updateUserBio(String username, UserBio userBio) throws NoDataException {
        try {
            openTransactionSession();

            Session session = getSession();
            User user = session.get(User.class, username);
            user.setBio(userBio);
            session.update(user);

            closeTransactionSession();
        } catch (PersistenceException e) {
            throw new NoDataException("There is no user with username: " + username);
        }
    }
}
