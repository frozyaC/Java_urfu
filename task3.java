package lr2_tasks;

import java.util.Scanner;

public class task3 {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Введите строку для кодирования \n");
    String s = in.next();
    System.out.print("Введите ключ/сдвиг для кодирования \n");
    int shift = in.nextInt();

    char[] chars = s.toCharArray();
    int[] numChar = new int[s.length()];
    int i = 0;
    for (char c: chars) {
        numChar[i] = (int) c + shift;
        System.out.print(numChar[i] + " ");
        i+=1;
    }

    System.out.println("\nТекст после преобразования: \n");
    for (int idx: numChar) {
        System.out.print((char) idx);
    }

    System.out.println("\nВыполнить обраное преобразование?\n");
    String ans = in.next();
    while (true) { 
        if (ans.equals("y")) {
        for (int idx: numChar) {
            System.out.print((char) (idx - shift));
        }
        break;
    } 
        else if (ans.equals("n")) {
            System.out.println("\nДо свидания!");
            break;
        } else {
            System.out.println("\nВведите корректный ответ\n");
            ans = in.next();
        } 
    }
   
    }
}