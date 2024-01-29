package Entidades;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class InfoPaisDAO {
    public static void ConsultarInfoPais(List<InfoPais> listInfoPais) {
        Session session = Connection.getSession();
        session.beginTransaction();
        Query<InfoPais> query = session.createQuery("FROM InfoPais", InfoPais.class);
        listInfoPais.addAll(query.list());
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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Paso 1: Persistir el objeto en la base de datos
            entityManager.persist(infoPais);
            entityManager.flush();
            entityManager.clear();

            infoPais = entityManager.find(InfoPais.class, infoPais.getId());
            assert infoPais != null; // Puedes usar las aserciones de tu elección
            // Paso 3: Eliminar el objet
            entityManager.remove(infoPais);
            entityManager.flush();
            entityManager.clear();

            // Paso 4: Verificar que el objeto realmente se haya eliminado
            InfoPais infoPaisAfterRemoval = entityManager.find(InfoPais.class, infoPais.getId());
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
