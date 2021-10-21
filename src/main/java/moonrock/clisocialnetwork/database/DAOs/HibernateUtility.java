package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user_contacts.UserContact;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class HibernateUtility {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().
                    addAnnotatedClass(User.class).
                    addAnnotatedClass(Message.class).
                    addAnnotatedClass(UserContact.class).
                    configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
