package Kurs_15_03_2022_My.T70;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Method m = Man.class.getDeclaredMethod("reflectionPrinter");
            m.setAccessible(true);
            m.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
