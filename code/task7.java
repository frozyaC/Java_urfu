import java.util.List;

public class task7 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк и возвращает новый список, содержащий только те строки, которые имеют длину больше заданного значения.";

        int wordLength = 6;

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringMoreThanLength = filterByLength(strings, wordLength);

        System.out.println("Строка после преобразования : " + stringMoreThanLength.toString()); 
    }

    public static List<String> filterByLength(List<String> list, int length) {
        return list.stream().filter(x -> x.length() > length).toList();
    }
}
