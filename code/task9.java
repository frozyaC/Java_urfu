import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        System.out.println("Введите кол-во строк: ");
        Scanner in = new Scanner(System.in);
        int linesNumber = in.nextInt();
    
        List<String> inputStringList = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < linesNumber; i++) {
            System.out.println("Введите строку: ");
            inputStringList.add(in.nextLine());
        }

        List<String> outputList = filterWordsStrings(inputStringList);

        System.out.println("Строки, где есть только буквы : " + outputList);
    }

    public static List<String> filterWordsStrings(List<String> inputStringList) {
        List<String> outputList = new ArrayList<>();
        for (String s : inputStringList) {
            if (s.matches("[a-zA-Zа-яА-ЯёЁ ]+")) {
                outputList.add(s);
            }
        }

        return outputList;
    }
}
