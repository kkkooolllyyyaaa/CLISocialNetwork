package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user_contacts.UserContact;
import org.hibernate.Session;

import javax.persistence.Query;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class UserContactDAOImpl extends SessionUtility implements UserContactDAO {
    @Override
    public UserContact getContactsOf(String username) {
        openTransactionSession();
        Session session = getSession();
        String sql = "SELECT contact_name FROM contacts WHERE username = :username";

        Query query = session.createNativeQuery(sql).addEntity(UserContact.class);
        query.setParameter("username", username);
        UserContact userContact = (UserContact) query.getSingleResult();

        closeTransactionSession();
        return userContact;
    }

    @Override
    public void addContact(UserContact userContact) {
        openTransactionSession();
        Session session = getSession();
        session.save(userContact);
        closeTransactionSession();
    }
}
