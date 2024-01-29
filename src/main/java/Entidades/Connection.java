package Entidades;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Connection {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();

        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    public static void closeSession() throws HibernateException {
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
