package JD2.Kurs_15_03_2022;

import java.util.*;

public class Storage {
    private Random rand;
    private ArrayList<Parts> storage;
    private int robotsCount;

    public Storage(){
        rand = new Random();
        storage = new ArrayList<>();
    }

    public ArrayList<Parts> GetStorage(){
        return storage;
    }
    public void PrintStorage(){
        System.out.println(Thread.currentThread().getName() + ": " + Arrays.toString(storage.toArray()) + " +" + (storage.size()-listSize));
    }
    public Parts takeStorageItem(){
        return storage.remove(rand.nextInt(storage.size()));
    }
    public void assembleRobot(){
        for (int i = 1; i < Main.PARTS_COUNT+1; i++) {
            storage.remove(Parts.ret(i));
        }
    }
    public void addStorageItem(Parts item){
        storage.add(item);
    }
    public boolean isContainsItems(Collection <Parts> c){
        return storage.containsAll(c);
    }

    public int getRobotsCount() {
        return robotsCount;
    }

    public void incRobotsCount() {
        robotsCount++;
    }

    private int listSize;//для отладки
    public void updateSizeVar(){
        listSize = storage.size();
    }
}
