package proj14042022;

import org.hibernate.HibernateException;
import proj14042022.entities.HomeTask;
import proj14042022.entities.Person;
import proj14042022.entities.Task;
import proj14042022.entities.WorkTask;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Task task = new Task();
        task.setName("T1");
        task.setDescription("...");

        HomeTask homeTask = new HomeTask();
        homeTask.setName("T2");
        homeTask.setDescription("...");
        homeTask.setStartDate(LocalDate.now());
        homeTask.setEndDate(LocalDate.now().plusDays(4));
        homeTask.setExecutor(new Person("name1", "surname1"));
        homeTask.setChecker(new Person("name2", "surname2"));

        WorkTask workTask = new WorkTask();
        workTask.setName("T3");
        workTask.setDescription("...");
        workTask.setCost("1000");

        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();

            em.getTransaction().begin();
            em.persist(homeTask);
            em.getTransaction().commit();

            em.getTransaction().begin();
            em.persist(workTask);
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
        }

        em.close();
        HibernateUtil.close();
        System.out.println("done");
    }
}
