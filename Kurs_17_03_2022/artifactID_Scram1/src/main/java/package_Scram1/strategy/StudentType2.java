package package_Scram1.strategy;

public class StudentType2 implements IStudentAction {

    @Override
    public double calculateTime(double talent, int generalTime) {
        return (double)Math.round((generalTime*2/talent)*100)/100;
    }

    private double calculateDeltaTime(double learningTime) {
        return learningTime/2;
    }

    @Override
    public void printInfo(double talent, double learningTime) {
        double deltaTime = calculateDeltaTime(learningTime);
        System.out.println("Тип студента: 2 | талант: " + talent + " | время на освоение: " + learningTime);
        System.out.println("Время на разбор: " + learningTime);
        System.out.println("Время на практику: " + learningTime);
    }
}
