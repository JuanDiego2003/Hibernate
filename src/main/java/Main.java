import Entidades.InfoPais;
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
                Query<InfoPais> query = session.createQuery("FROM Cafes", InfoPais.class);
                for (InfoPais c: query.list()) {
                    System.out.println(c);
                }
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
