package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user_contacts.UserContacts;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UserContactsDAO {
    UserContacts getContactsOf(String username);
}
