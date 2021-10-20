package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.database.HibernateConfigurer;
import moonrock.clisocialnetwork.entities.message.Message;
import moonrock.clisocialnetwork.entities.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class MessagesDAOImpl implements MessagesDAO, HibernateConfigurer {
    @Override
    public Message getAll(User user1, User user2) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT content FROM messages WHERE user1 = :user1 AND user2 = " +
                    ":user2 ";
            Query query = session.createNativeQuery(sql).addEntity(Message.class);
            query.setParameter("user1", user1);
            query.setParameter("user2", user2);
            Message message = (Message) query.getSingleResult();
            transaction.commit();
            session.close();
            return message;
        }
    }

    @Override
    public Message getLastMessage(User user1, User user2) {
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String sql = "SELECT * FROM messages WHERE id = (SELECT max(id) FROM" +
                    "messages)";
            Query query = session.createNativeQuery(sql).addEntity(Message.class);
            Message message = (Message) query.getSingleResult();
            transaction.commit();
            session.close();
            return message;
        }
    }
}
