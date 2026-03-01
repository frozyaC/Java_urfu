package lr1_package;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Введите фамилию");
        String surname = in.nextLine();

        System.out.println("Введите имя");
        String name = in.nextLine();

        System.out.println("Введите отчество");
        String last_name = in.nextLine();

        String output_str = "Hello " + surname + " " + name + " " + last_name;
        System.out.println(output_str); 
    }
}
