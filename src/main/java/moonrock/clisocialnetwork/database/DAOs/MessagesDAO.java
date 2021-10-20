package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface MessagesDAO {
    Message getAll(User user1, User user2);

    Message getLastMessage(User user1, User user2);
}
