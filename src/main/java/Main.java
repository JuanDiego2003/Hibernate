import Entidades.Cafes;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                Query<Cafes> query = session.createQuery("FROM Cafes", Cafes.class);
                for (Cafes c: query.list()) {
                    System.out.println(c);
                }
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
