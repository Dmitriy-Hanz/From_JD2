package proj12042022;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hibernate.HibernateException;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import proj12042022.entities.Address;
import proj12042022.entities.People;

import javax.persistence.EntityManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest 
{
    private static EntityManager em = null;
    private static Address address = null;
    private static People people = null;
    private static Address addressFromDB = null;
    private static People peopleFromDB = null;

    @BeforeClass
    public static void Preset() {
        address = Address.builder().city("city").street("street").house("number").build();
        people = People.builder().name("name").surname("surname").patronymic("patronymic").build();
        try {
            em = HibernateTestUtil.getEntityManager();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    @Test
    public void TestHibernateInsert()
    {
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.persist(people);
            em.getTransaction().commit();
            assertTrue( true );
        }catch (HibernateException he){
            em.getTransaction().rollback();
            fail();
        }
    }

    @Test
    public void TestHibernateRead()
    {
        try {
            em.getTransaction().begin();
            addressFromDB = em.find(Address.class, address.getId());
            peopleFromDB = em.find(People.class, people.getId());
            em.getTransaction().commit();
            assertTrue( true );
        }catch (HibernateException he){
            em.getTransaction().rollback();
            fail();
        }
    }

    @Test
    public void TestHibernateUpdate()
    {
        try {
            em.getTransaction().begin();
            addressFromDB.setCity("new city");
            peopleFromDB.setName("new name");
            em.merge(addressFromDB);
            em.merge(peopleFromDB);
            em.getTransaction().commit();
            assertTrue( true );
        }catch (HibernateException he){
            em.getTransaction().rollback();
            fail();
        }
    }

    @Test
    public void TestHibernateRemove()
    {
        try {
            em.getTransaction().begin();
            em.remove(addressFromDB);
            em.remove(peopleFromDB);
            em.getTransaction().commit();
            assertTrue( true );
        }catch (HibernateException he){
            em.getTransaction().rollback();
            fail();
        }
    }
}
