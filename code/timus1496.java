import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class timus1496 {
    public static void main(String[] args) {
        System.out.println("Введите количество сабмитов в последние 10 минут: ");

        Scanner in = new Scanner(System.in);
        int submitNumber = in.nextInt();

        String[] teamNames = new String[submitNumber];

        for (int i = 0; i < submitNumber; i++) {
            System.out.println("Введите название команды: ");
            teamNames[i] = in.next();
        }

        System.out.println("Команды спамеры: " + moreThanOneSubmit(teamNames));
    }

    public static List<String> moreThanOneSubmit(String[] teamNames) {
        List<String> spamNames = new ArrayList<>();
        for (String target : teamNames) {
            int count = 0;
            for (String name : teamNames) {
                if (name.equals(target)) {
                    count++;
                }
            }

            if (count > 1) {
                if (!spamNames.contains(target)) {
                    spamNames.add(target);
                }
            }
        }
        return spamNames;
    }
}
