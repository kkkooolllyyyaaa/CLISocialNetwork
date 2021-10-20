package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.database.HibernateConfigurer;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UsersDAOImpl implements UsersDAO, HibernateConfigurer {

    @Override
    public boolean isExist(String username, String password) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT username AND password FROM users WHERE" +
                    "username =:username AND password = :password";
            Query query = session.createNativeQuery(sql);
            List<Object[]> list = query.setParameter("username", username).getResultList();
            User user = (User) query.getSingleResult();
            if (list.isEmpty()) {
                transaction.commit();
                session.close();
                return false;
            } else {
                user.getPassword().equals(password);
                transaction.commit();
                session.close();
                return true;
            }
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT * FROM users WHERE username = :username";

            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();
            transaction.commit();
            session.close();
            return user;
        }
    }

    @Override
    public List<User> getAll() {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT * FROM users";
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            List<User> userList = query.getResultList();
            transaction.commit();
            session.close();
            return userList;
        }
    }

    @Override
    public void addUser(User user) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();

        }
    }

    @Override
    public void deleteUser(User user) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void updateUserBio(String username, UserBio userBio) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, username);
            user.setBio(userBio);
            session.update(user);
            transaction.commit();
            session.close();
        }
    }
}
