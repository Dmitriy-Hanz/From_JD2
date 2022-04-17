package proj12042022;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateTestUtil {
    public static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("testDB");
    }
    public static EntityManager getEntityManager (){
        return emFactory.createEntityManager();
    }
    public static void close(){
        emFactory.close();
    }
}
