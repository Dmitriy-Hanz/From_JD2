package package_Scram1;
import package_Scram1.strategy.*;

import java.util.LinkedList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Student> students = new LinkedList<Student>();
        for (int i = 0; i < 3; i++) {
            students.add(new Student("Студент " + i,new StudentType1()));
            students.add(new Student("Студент " + i,new StudentType2()));
            students.add(new Student("Студент " + i,new StudentType3()));
        }
        for (Student item: students) {
            item.aboutStudent();
            System.out.println();
        }
    }
}
