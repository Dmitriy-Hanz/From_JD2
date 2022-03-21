package package_Scram1.strategy;

public class StudentType3 implements IStudentAction {

    @Override
    public double calculateTime(double talent, int generalTime) {
        return (double)Math.round((generalTime*3/talent)*100)/100;
    }

    @Override
    public void printInfo(double talent, double learningTime) {
        System.out.println("Тип студента: 3 | талант: " + talent + " | время на освоение: " + learningTime);
        System.out.println("Время на практику: " + learningTime);
    }
}
