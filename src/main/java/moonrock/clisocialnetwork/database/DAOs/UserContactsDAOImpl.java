package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.database.HibernateConfigurer;
import moonrock.clisocialnetwork.entities.user_contacts.UserContacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UserContactsDAOImpl implements UserContactsDAO, HibernateConfigurer {
    @Override
    public UserContacts getContactsOf(String username) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT contact_name FROM contacts WHERE username = :username";

            Query query = session.createNativeQuery(sql).addEntity(UserContacts.class);
            query.setParameter("username", username);
            UserContacts userContacts = (UserContacts) query.getSingleResult();
            transaction.commit();
            session.close();
            return userContacts;
        }
    }
}
