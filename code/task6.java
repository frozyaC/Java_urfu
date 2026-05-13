
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class task6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String filePath = "code/files/task6/" + in.nextLine();
        System.out.println("Введите слово для поиска:");
        String keyWord = in.nextLine();
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            System.out.println("Строки, содержащие " + keyWord + ": ");
            String str = reader.readLine();
            while (str != null) {
                if (str.contains(keyWord)) {
                    System.out.println(str);
                }
                str = reader.readLine();
            }
            reader.close();
        } else {
            System.out.println("Такой файл не найден");
        }
    }
}
