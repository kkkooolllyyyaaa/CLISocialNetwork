package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.exceptions.DataExistException;
import moonrock.clisocialnetwork.exceptions.NoDataException;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface MessagesDAO {
    void addMessage(Message message) throws DataExistException;

    int getNextId();

    Message getAll(User user1, User user2);

    Message getLastMessage(User user1, User user2) throws NoDataException;
}
