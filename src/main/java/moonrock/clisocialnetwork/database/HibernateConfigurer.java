package moonrock.clisocialnetwork.database;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user_contacts.UserContacts;
import org.hibernate.cfg.Configuration;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface HibernateConfigurer {
    Configuration configuration = new Configuration();

    default void configure() {
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Message.class);
        configuration.addAnnotatedClass(UserContacts.class);
    }
}
