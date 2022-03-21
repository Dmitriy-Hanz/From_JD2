package package_Scram1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import package_Scram1.strategy.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static Method[] StudentType1Methods;
    private static Method[] StudentType2Methods;

    @Before
    public void PreSet()
    {
        StudentType1Methods = StudentType1.class.getDeclaredMethods();
        StudentType2Methods = StudentType2.class.getDeclaredMethods();
    }

    @Test
    public void CalculateTimeType1()
    {
        StudentType1 t1 = new StudentType1();
        assertEquals(198, t1.calculateTime(1, 198),0);
        assertEquals(282.86, t1.calculateTime(0.7, 198), 0);
    }

    @Test
    public void CalculateTimeType2()
    {
        StudentType2 t2 = new StudentType2();
        assertEquals(396, t2.calculateTime(1, 198),0);
        assertEquals(565.71, t2.calculateTime(0.7, 198), 0);
    }

    @Test
    public void CalculateTimeType3()
    {
        StudentType3 t3 = new StudentType3();
        assertEquals(594, t3.calculateTime(1, 198),0);
        assertEquals(848.57, t3.calculateTime(0.7, 198), 0);
    }

    @Test
    public void CalculateDeltaTimeType1()
    {
        StudentType1 t1 = new StudentType1();
        try {
            Method m = Arrays.stream(StudentType1Methods).filter((p)->p.getName().equals("calculateDeltaTime")).findFirst().get();
            m.setAccessible(true);
            assertEquals(66,(double)m.invoke(t1,198),0);
            assertEquals(94.29,(double)m.invoke(t1,282.86),0);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void CalculateDeltaTimeType2()
    {
        StudentType2 t2 = new StudentType2();
        try {
            Method m = Arrays.stream(StudentType2Methods).filter((p)->p.getName().equals("calculateDeltaTime")).findFirst().get();
            m.setAccessible(true);
            assertEquals(99,(double)m.invoke(t2,198),0);
            assertEquals(141.43,(double)m.invoke(t2,282.86),0);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
