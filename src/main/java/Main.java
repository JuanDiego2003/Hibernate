import Entidades.CafeTypes;
import Entidades.InfoPais;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
                InfoPais infoPais = new InfoPais();
                infoPais.setId(2);
                infoPais.setPais("col");
                infoPais.setAnos2016_17(1);
                infoPais.setAnos2017_18(2);
                infoPais.setAnos2018_19(3);
                infoPais.setAnos2019_20(4);
                infoPais.setTotal_domestic_consumption(10);
                session.save(infoPais);
                session.getTransaction().commit();
            System.out.println("sdf");

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
