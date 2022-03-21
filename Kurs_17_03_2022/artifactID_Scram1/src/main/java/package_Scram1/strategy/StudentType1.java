package package_Scram1.strategy;

public class StudentType1 implements IStudentAction {
    @Override
    public double calculateTime(double talent, int generalTime) {
        return (double)Math.round((generalTime/talent)*100)/100;
    }

    private double calculateDeltaTime(double learningTime) {
        return (double)Math.round((learningTime/3)*100)/100;
    }

    @Override
    public void printInfo(double talent,double learningTime) {
        double deltaTime = calculateDeltaTime(learningTime);
        System.out.println("Тип студента: 1 | талант: " + talent + " | время на освоение: " + learningTime);
        System.out.println("Время на разбор: " + deltaTime);
        System.out.println("Время на практику: " + deltaTime);
        System.out.println("Время на поток: " + deltaTime);
    }
}
