package Entidades;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CafeTypesDAO {
    public static void ConsultarCafeTypes(List<CafeTypes> listCafeTypes){
        Session session = Connection.getSession();
        session.beginTransaction();
        Query<CafeTypes> query = session.createQuery("FROM CafeTypes", CafeTypes.class);
        listCafeTypes.addAll(query.list());
        session.getTransaction().commit();
    }
    public static void InsertarCafeTypes(CafeTypes cafeTypes){
        Session session = Connection.getSession();
        session.beginTransaction();
        session.save(cafeTypes);
        session.getTransaction().commit();

    }
    public static void EliminarCafeTypes (CafeTypes cafeTypes){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Paso 1: Persistir el objeto en la base de datos
            entityManager.persist(cafeTypes);
            entityManager.flush();
            entityManager.clear();

            cafeTypes = entityManager.find(CafeTypes.class, cafeTypes.getId());
            assert cafeTypes != null; // Puedes usar las aserciones de tu elección
            // Paso 3: Eliminar el objet
            entityManager.remove(cafeTypes);
            entityManager.flush();
            entityManager.clear();

            // Paso 4: Verificar que el objeto realmente se haya eliminado
            CafeTypes infoPaisAfterRemoval = entityManager.find(CafeTypes.class, cafeTypes.getId());
            if (infoPaisAfterRemoval==null){
                System.out.println("Se ha eliminado correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
