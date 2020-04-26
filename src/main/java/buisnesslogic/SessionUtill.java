package BuisnessLogic;

import buisnesslogic.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtill {

    private Session session;
    private Transaction transaction;

    public Session getSession(){
        return session;
    }

    public Transaction getTransaction(){
        return transaction;
    }

    public Session openSession(){
        return HibernateUtill.getSessionFactory().openSession();
    }

    public Session openTransactionSession(){
        session = openSession();
        transaction = session.beginTransaction();
        return  session;
    }

    public void closeSession(){
        session.close();
    }

    public void closeTransactionSession(){
        transaction.commit();
        closeSession();
    }
}
