package proj14042022;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hibernate.HibernateException;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import proj14042022.entities.HomeTask;
import proj14042022.entities.Person;
import proj14042022.entities.Task;
import proj14042022.entities.WorkTask;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
    private static EntityManager em = null;
    private static Task task;
    private static HomeTask homeTask;
    private static WorkTask workTask;

    @BeforeClass
    public static void Preset() {
        task = new Task();
        task.setName("T1");
        task.setDescription("...");

        homeTask = new HomeTask();
        homeTask.setName("T2");
        homeTask.setDescription("...");
        homeTask.setStartDate(LocalDate.now());
        homeTask.setEndDate(LocalDate.now().plusDays(4));
        homeTask.setExecutor(new Person("name1", "surname1"));
        homeTask.setChecker(new Person("name2", "surname2"));

        workTask = new WorkTask();
        workTask.setName("T3");
        workTask.setDescription("...");
        workTask.setCost("1000");
        try {
            em = HibernateTestUtil.getEntityManager();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    @Test
    public void TestHibernateInsertTask() {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
            assertTrue(true);
        } catch (HibernateException he) {
            em.getTransaction().rollback();
            fail();
        }
    }

    @Test
    public void TestHibernateInsertHomeTask() {
        try {
            em.getTransaction().begin();
            em.persist(homeTask);
            em.getTransaction().commit();
            assertTrue(true);
        } catch (HibernateException he) {
            em.getTransaction().rollback();
            fail();
        }
    }

    @Test
    public void TestHibernateInsertWorkTask() {
        try {
            em.getTransaction().begin();
            em.persist(workTask);
            em.getTransaction().commit();
            assertTrue(true);
        } catch (HibernateException he) {
            em.getTransaction().rollback();
            fail();
        }
    }
}

