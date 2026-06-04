import java.util.Scanner;

public class timus1283 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Количество золота в начале: ");
        int initGold = in.nextInt();
        System.out.println("Введите количество золота, при котором жизнь гномика лишается смысла: ");
        int endGold = in.nextInt();
        System.out.println("Введите комиссию ЦГБ в процентах (1-99): ");
        float comission = in.nextInt();

        float leftGold = initGold;
        int yearsCounter = 0;
        while (leftGold > endGold) {
            yearsCounter++;
            leftGold = leftGold - leftGold * (comission / 100);
        }

        System.out.println("Гномику осталось жить (лет): " + yearsCounter + ".");
        in.close();
    }
}
