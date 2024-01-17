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
                InfoPais infoPais = new InfoPais();
                infoPais.setId(1);
                infoPais.setPais("col");
                infoPais.setAnos2016_17(1);
                infoPais.setAnos2017_18(2);
                infoPais.setAnos2018_19(3);
                infoPais.setAnos2019_20(4);
                infoPais.setTotal_domestic_consumption(10);
                session.save(infoPais);
            }

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
