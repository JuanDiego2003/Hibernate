package Entidades;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CafeTypesDAO {
    public static void ConsultarCafeTypes(List<CafeTypes> listCafeTypes) {
        Session session = Connection.getSession();
        session.beginTransaction();
        try {
            String consul = "FROM CafeTypes";
            if (!listCafeTypes.isEmpty()) {
                if (listCafeTypes.get(0) != null) {
                    if (listCafeTypes.get(0).getId() != 0) {
                        consul += " WHERE id = :id";
                        Query<CafeTypes> query = session.createQuery(consul, CafeTypes.class);
                        query.setParameter("id", listCafeTypes.get(0).getId());
                        listCafeTypes.clear();
                        listCafeTypes.addAll(query.list());
                    } else if (!listCafeTypes.get(0).getCafeType().isEmpty()) {
                        consul += " WHERE cafeType = :cafe";
                        System.out.println(consul);
                        Query<CafeTypes> query = session.createQuery(consul, CafeTypes.class);
                        query.setParameter("cafe", listCafeTypes.get(0).getCafeType());
                        System.out.println(listCafeTypes.get(0).getCafeType());
                        listCafeTypes.clear();
                        listCafeTypes.addAll(query.list());
                    }
                } else {
                    listCafeTypes.clear();
                    Query<CafeTypes> query = session.createQuery(consul, CafeTypes.class);
                    listCafeTypes.addAll(query.list());
                }
            } else {
                listCafeTypes.clear();
                Query<CafeTypes> query = session.createQuery(consul, CafeTypes.class);
                listCafeTypes.addAll(query.list());
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

    public static void InsertarCafeTypes(CafeTypes cafeTypes) {
        Session session = Connection.getSession();
        session.beginTransaction();
        try {

            session.save(cafeTypes);
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

    public static void ActualizarCafeTypes(List<CafeTypes> cafeTypes) {
        Session session = Connection.getSession();
        session.beginTransaction();
        try {
            session.save(cafeTypes.get(0));
            session.update(cafeTypes.get(1));
            System.out.println("Actualizacion realizada");
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

    public static void EliminarCafeTypes(CafeTypes cafeTypes) {
        Session session = Connection.getSession();
        session.beginTransaction();
        boolean correct = false;
        try {
            cafeTypes = session.find(CafeTypes.class, cafeTypes.getId());
            session.remove(cafeTypes);
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
