package Kurs_15_03_2022_My.T70;

import java.util.Arrays;
import java.util.Date;

public class Man {
    private int health;
    private boolean liveState;
    private String name;
    private Date birthDate;

    public Man(int health, boolean liveState, String name, Date birthDate) {
        this.health = health;
        this.liveState = liveState;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Man() {
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public boolean getLiveState() {
        return liveState;
    }
    public void setLiveState(boolean liveState) {
        this.liveState = liveState;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void speak(){
        System.out.println("Speak");
    }
    public void walk(){
        System.out.println("walk");
    }
    public void swim(){
        System.out.println("swim");
    }
    public void work() {
        System.out.println("work");
    }

    public static void reflectionPrinter(){
        System.out.println("Имя класса: " + Man.class.getSimpleName());

        if (Man.class.getDeclaredFields().length != 0){
            System.out.println("Поля: " + Arrays.stream(Man.class.getDeclaredFields()).map((p) -> p.getName()).reduce((p1, p2) -> p1 + ", " + p2).get());
        }
        if (Man.class.getDeclaredMethods().length != 0){
            System.out.println("Методы: " + Arrays.stream(Man.class.getDeclaredMethods()).map((p) -> p.getName()).reduce((p1, p2) -> p1 + ", " + p2).get());
        }
    }
}
