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
        Session session = openTransactionSession();
        TypedQuery<User> query = session.createQuery("from User", User.class);
        List<User> userList = query.getResultList();

        closeTransactionSession();
        return userList;
    }

    @Override
    public boolean isUserExist(String username, String password) {
        try {
            Session session = openTransactionSession();
            String sql = "SELECT * FROM users WHERE username = :username";
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();

            closeTransactionSession();
            return user != null && user.getPassword().equals(password);
        } catch (PersistenceException e) {
            return false;
        }
    }

    @Override
    public boolean isUsernameExist(String username) {
        try {
            Session session = openTransactionSession();
            String sql = "SELECT * FROM users WHERE username = :username";
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();

            closeTransactionSession();
            return user != null;
        } catch (PersistenceException e) {
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) throws NoDataException {
        try {
            Session session = openTransactionSession();
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
            Session session = openTransactionSession();
            session.save(user);

            closeTransactionSession();
        } catch (Exception e) {
            throw new DataExistException("User with username: " + user + " already exists");
        }
    }

    @Override
    public void deleteUser(User user) throws NoDataException {
        try {
            Session session = openTransactionSession();
            session.remove(user);

            closeTransactionSession();
        } catch (Exception e) {
            throw new NoDataException("There is no user with this username and password");
        }
    }

    @Override
    public void updateUserBio(String username, UserBio userBio) throws NoDataException {
        try {
            Session session = openTransactionSession();
            User user = session.get(User.class, username);
            user.setBio(userBio);
            user.initDisplayBio();
            session.update(user);

            closeTransactionSession();
        } catch (PersistenceException e) {
            throw new NoDataException("There is no user with username: " + username);
        }
    }
}
