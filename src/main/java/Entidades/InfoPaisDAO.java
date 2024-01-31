package Entidades;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InfoPaisDAO {
    public static void ConsultarInfoPais(List<InfoPais> listInfoPais) {
        Session session = Connection.getSession();
        session.beginTransaction();
        String consul = "FROM InfoPais";
        if (!listInfoPais.isEmpty()) {
            if (listInfoPais.get(0) != null) {
                if (listInfoPais.get(0).getId() != 0) {
                    consul += " WHERE id = :id";
                    Query<InfoPais> query = session.createQuery(consul, InfoPais.class);
                    query.setParameter("id", listInfoPais.get(0).getId());
                    listInfoPais.clear();
                    listInfoPais.addAll(query.list());
                } else if (!listInfoPais.get(0).getPais().isEmpty()) {
                    consul += " WHERE pais = :pais";
                    Query<InfoPais> query = session.createQuery(consul, InfoPais.class);
                    query.setParameter("pais", listInfoPais.get(0).getPais());
                    System.out.println(listInfoPais.get(0).getPais());
                    listInfoPais.clear();
                    listInfoPais.addAll(query.list());
                }
            } else {
                listInfoPais.clear();
                Query<InfoPais> query = session.createQuery(consul, InfoPais.class);
                listInfoPais.addAll(query.list());
            }
        } else {
            Query<InfoPais> query = session.createQuery(consul, InfoPais.class);
            listInfoPais.addAll(query.list());
        }
        session.getTransaction().commit();
    }


    public static void InsertarInfoPais(InfoPais infoPais) {
        Session session = Connection.getSession();
        session.clear();
        session.beginTransaction();
        session.save(infoPais);
        session.getTransaction().commit();

    }

    public static void EliminarInfoPais(InfoPais infoPais) {
        Session session = Connection.getSession();
        session.clear();
        session.beginTransaction();
        String consul="DELETE FROM InfoPais WHERE id = :valor";
        Query query = session.createQuery(consul);
        query.setParameter("valor", infoPais.getId());
        int deletedCount = query.executeUpdate();
        if (deletedCount>0){
            System.out.println("Se ha eliminada");
        }else {
            System.out.println("no hay datos eliminados");
        }
        session.getTransaction().commit();
    }
    public static void ActualizarInfoPais(List<InfoPais> infoPaises){
        Session session = Connection.getSession();
        session.clear();
        session.beginTransaction();
        session.save(infoPaises.get(0));
        session.evict(infoPaises.get(1));
    }
}
