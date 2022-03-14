package JD2.Kurs_15_03_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main{
    public static final int PARTS_COUNT = Parts.values().length;
    public static final int NIGHTS_COUNT = 100;
    public static final int RANDOM_DETAILS_PUT_COUNT = 4;
    public static final int RANDOM_DETAILS_TAKE_COUNT = 4;


    public static void main(String[] args) {
        Storage storage1 = new Storage();
        Storage storage2 = new Storage();
        Dump dump = new Dump();

        Factory factory = new Factory(dump);
        Servant servant1 = new Servant(dump,storage1);
        Servant servant2 = new Servant(dump,storage2);


        Random rand = new Random();
        for (int j = 0; j < 20; j++) {
            dump.addDumpItem(Parts.ret(rand.nextInt(PARTS_COUNT + 1)));
        }


        System.out.println("Хранилища с деталями: ");
        Thread factoryT = new Thread(factory);
        Thread servant1T = new Thread(servant1,"1");
        Thread servant2T = new Thread(servant2,"2");

        factoryT.start();
        servant1T.start();
        servant2T.start();
    }
}


class Servant implements Runnable {
    Random rand = new Random();
    private Dump dumpSource;
    private Storage storageSource;

    public Servant(Dump dumpSource, Storage storageSource) {
        this.dumpSource = dumpSource;
        this.storageSource = storageSource;
    }

    public void run() {
        for (int i = 0; i < Main.NIGHTS_COUNT; i++) {
            storageSource.updateSizeVar();//для отладки
            for (int j = 0; j < rand.nextInt(Main.RANDOM_DETAILS_TAKE_COUNT) + 1; j++)
            {
                synchronized (dumpSource){
                    if (dumpSource.isDumpEmpty()) {
                        break;
                    }
                    storageSource.addStorageItem(dumpSource.takeDumpItem());
                }
            }

            storageSource.PrintStorage();

            while (storageSource.isContainsItems(List.of(Parts.values()))) {
                storageSource.assembleRobot();
                storageSource.incRobotsCount();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кол-во роботов у " + Thread.currentThread().getName() + " ученого: " + storageSource.getRobotsCount());
    }
}
