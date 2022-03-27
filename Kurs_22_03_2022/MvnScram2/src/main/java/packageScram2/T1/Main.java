package packageScram2.T1;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class Main
{
    public static final int PERSON_COUNT=100;
    public static void main( String[] args )
    {
        Random rand = new Random();
        List<Person> group = new LinkedList<>();
        int temp;
        for (int i = 0; i < PERSON_COUNT; i++) {
            temp = rand.nextInt(PERSON_COUNT)+1;
            group.add(new Person("name"+temp,"surname"+temp,rand.nextInt(16)+15));
        }
        List<Person> filteredGroup = selectLessThen21(group);
        printGroup(filteredGroup);

        List<Person> sortedGroup = sortByNameAndSurname(filteredGroup);
        List<Person> uniqueGroup = removeDuplicates(sortedGroup);

        File file = new File("src/main/java/packageScram2/T1/groups.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        WriteToFile(file,uniqueGroup);

        group = ReadFromFile(file);

        List<String> stringGroup = group.stream().map(p -> { return p.getName() + " " + p.getSurname();}).toList();

        System.out.println();
        printGroup(stringGroup);
    }

    public static List<Person> selectLessThen21(List<Person> list){
        return list.stream().filter((p) -> p.getAge() < 21).collect(Collectors.toList());
    }
    public static void printGroup(List<?> list){
        for (var item: list) {
            System.out.println(item);
        }
    }
    public static List<Person> sortByNameAndSurname(List<Person> list){
        return list.stream().sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName)).collect(Collectors.toList());
    }
    public static List<Person> removeDuplicates(List<Person> list){
        return list.stream().distinct().toList();
    }
    public static void WriteToFile(File file,List<Person> list) {

        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos=new ObjectOutputStream(fos))
        {
            for (var item: list) {
                oos.writeObject(item);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Person> ReadFromFile(File file) {
        List<Person> temp = new LinkedList<>();
        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois=new ObjectInputStream(fis))
        {
            while (fis.available() != 0)
            {
                temp.add((Person)ois.readObject());
            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }
}
