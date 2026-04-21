import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task5 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in, "UTF-8");
            String inputString = "Шла Саша по шоссе и сосала сушку";
            List<String> inputStringList = List.of(inputString.split(" "));

            System.out.println("Исходная строка : " + inputStringList);

            String substr = "са";

            List<String> outputList = findSubstr(substr, inputStringList);

            System.out.println("Результат : " + outputList);
    }

    public static List<String> findSubstr(String substr, List<String> inputStringArray) {
        String cleanSubstr = substr.trim().toLowerCase();
        return inputStringArray.stream()
            .filter(s -> s.toLowerCase().contains(cleanSubstr))
            .collect(Collectors.toList());
    }
}
