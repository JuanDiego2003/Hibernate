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
        try {
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
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("se ha producido un error");
        } finally {
            session.close();
        }
    }


    public static void InsertarInfoPais(InfoPais infoPais) {
        Session session = Connection.getSession();
        session.beginTransaction();
        try {
            session.save(infoPais);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("se ha producido un error");
        } finally {
            session.close();
        }
    }

    public static void ActualizarInfoPais(List<InfoPais> infoPaises) {
        Session session = Connection.getSession();
        session.beginTransaction();
        try {
            session.save(infoPaises.get(0));
            session.update(infoPaises.get(1));
            session.getTransaction().commit();

            System.out.println("Actualizacion realizada");

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("se ha producido un error");
        } finally {
            session.close();
        }
    }

    public static void EliminarInfoPais(InfoPais infoPais) {
        Session session = Connection.getSession();
        session.beginTransaction();
        boolean correct = false;
        try {
            infoPais = session.find(InfoPais.class, infoPais.getId());
            session.remove(infoPais);
            session.getTransaction().commit();
            System.out.println("Eliminado correctamente");
            correct = true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("se ha producido un error");
        } finally {

            session.close();
        }
    }
}
