package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.database.HibernateConfigurer;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UsersDAOImpl implements UsersDAO, HibernateConfigurer {
    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            transaction.commit();
        }
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
