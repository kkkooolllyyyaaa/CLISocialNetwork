package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user_contacts.UserContact;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UserContactDAO {
    UserContact getContactsOf(String username);

    void addContact(UserContact userContact);
}
