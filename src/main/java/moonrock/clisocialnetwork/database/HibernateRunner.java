package moonrock.clisocialnetwork.database;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user_contacts.UserContacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class HibernateRunner {
    public HibernateRunner() {
        configure();
    }

    private void configure() {
        Configuration configuration = new Configuration();
        configuration.configure();
        addAnnotatedClasses(configuration);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            System.out.println("ok");
        }
    }

    private void addAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Message.class);
        configuration.addAnnotatedClass(UserContacts.class);
    }
}
