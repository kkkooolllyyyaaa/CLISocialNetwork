package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.user.User;
import moonrock.clisocialnetwork.user.userData.UserBio;
import org.hibernate.SessionFactory;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UsersDAOImpl implements UsersDAO {
    private SessionFactory sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public CopyOnWriteArrayList<User> getAll() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUserBio(User user, UserBio userBio) {

    }
}
