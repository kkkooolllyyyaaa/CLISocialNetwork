package moonrock.clisocialnetwork.database.DAOs;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class SessionUtility {
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }


    public Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeTransactionSession() {
        transaction.commit();
        closeSession();
    }

    private void closeSession() {
        session.close();
    }

    private Session openSession() {
        return HibernateUtility.getSessionFactory().openSession();
    }

}
