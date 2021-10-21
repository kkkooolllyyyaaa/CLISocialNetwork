package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.exceptions.NoDataException;
import org.hibernate.Session;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class MessagesDAOImpl extends SessionUtility implements MessagesDAO {
    @Override
    public Message getAll(User from, User to) {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT content FROM messages WHERE user1 = :user1 AND user2 = " +
                ":user2 ";
        Query query = session.createNativeQuery(sql).addEntity(Message.class);
        query.setParameter("user1", from);
        query.setParameter("user2", to);
        Message message = (Message) query.getSingleResult();

        closeTransactionSession();
        return message;
    }

    @Override
    public Message getLastMessage(User from, User to) {
        try {
            openTransactionSession();
            Session session = getSession();
            String sql = "SELECT * FROM messages WHERE id = (SELECT max(id) FROM" +
                    "messages)";
            Query query = session.createNativeQuery(sql).addEntity(Message.class);
            Message message = (Message) query.getSingleResult();
            closeTransactionSession();

            return message;
        } catch (PersistenceException e) {
            throw new NoDataException("There is no messages of users: " + from.getUsername() + " " + to.getUsername());
        }
    }

    @Override
    public void addMessage(Message message) {
        openTransactionSession();
        Session session = getSession();
        session.save(message);
        closeTransactionSession();
    }

    @Override
    public int getNextId() {
        openTransactionSession();
        Session session = getSession();
        String sql = "SELECT MAX(id) FROM messages";
        Query query = session.createNativeQuery(sql).addEntity(Message.class);
        int nextId = ((Integer) query.getSingleResult()) + 1;
        closeTransactionSession();
        return nextId;
    }
}
