package package_Scram1;

import package_Scram1.strategy.IStudentAction;

import java.util.Random;

public class Student {
    public static final int GENERAL_TIME = 198;

    private double talent;
    private double learningTime;
    private String name;
    IStudentAction type;

    public Student(String name, IStudentAction type) {
        Random rand = new Random();
        talent = (double)(rand.nextInt(10)+1)/10;
        this.type = type;
        this.name = name;
    }

    public void aboutStudent(){
        learningTime = type.calculateTime(talent,GENERAL_TIME);
        type.printInfo(talent,learningTime);
    }
}
