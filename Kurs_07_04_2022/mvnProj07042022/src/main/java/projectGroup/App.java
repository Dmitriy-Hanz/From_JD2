package projectGroup;

import projectGroup.dao.RequestExecutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Введите запрос в базу данных...");
        Scanner input = new Scanner(System.in);
        String request = input.nextLine();
        RequestExecutor.execute(request);
    }
}
