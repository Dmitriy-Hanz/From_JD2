package proj12042022;

import org.hibernate.HibernateException;
import proj12042022.entities.Address;
import proj12042022.entities.People;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        Address a = Address.builder().city("city17").street("street17").house("17").build();
        People p = People.builder().name("name1").surname("surname1").patronymic("patronymic1").build();

        EntityManager em = HibernateUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(a);
            em.persist(p);
            em.getTransaction().commit();

            em.getTransaction().begin();
            Address aFromDB = em.find(Address.class, a.getId());
            People pFromDB = em.find(People.class, p.getId());
            em.getTransaction().commit();

            em.getTransaction().begin();
            aFromDB.setCity("city1");
            pFromDB.setName("new name");
            em.merge(aFromDB);
            em.merge(pFromDB);
            em.getTransaction().commit();

            em.getTransaction().begin();
            em.remove(aFromDB);
            em.remove(pFromDB);
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
        }

        em.close();
        HibernateUtil.close();
        System.out.println("done");
    }
}
