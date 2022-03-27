package packageScram2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import packageScram2.T1.Main;
import packageScram2.T1.Person;

import java.util.LinkedList;
import java.util.List;

public class MainTest
{
    private static List<Person> list;
    private static List<Person> temp;

    @Before
    public void PreSet()
    {
        list = new LinkedList<>();
        list.add(new Person("name3","surname2",20));
        list.add(new Person("name2","surname2",21));
        list.add(new Person("name1","surname1",22));
        list.add(new Person("name1","surname1",22));
    }

    @Test
    public void testSelectLessThen21()
    {
        temp = Main.selectLessThen21(list);
        if (temp.contains(list.get(0)) & temp.size() == 1){
            assertTrue( true );
        }
    }

    @Test
    public void testSortByNameAndSurname()
    {
        temp = Main.sortByNameAndSurname(list);
        if (temp.get(0).equals(list.get(3)) & temp.get(2).equals(list.get(1))){
            assertTrue( true );
        }
    }

    @Test
    public void testRemoveDuplicates()
    {
        temp = Main.removeDuplicates(list);
        if (temp.size() == 3 & temp.get(2).equals(list.get(2))){
            assertTrue( true );
        }
        //assertEquals();
    }
}
