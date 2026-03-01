package lr1_package;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите день недели");
        String weekday = in.nextLine();

        System.out.println("Введите месяц");
        String month = in.nextLine();

        System.out.println("Введите дату");
        int day = in.nextInt();

        System.out.println("День недели: " + weekday + "\n Дата: " + day + "\n Месяц: " + month);
    }

}
