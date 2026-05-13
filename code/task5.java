import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class task5 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла для проверки его размера: ");
        String filePath = "code/files/task5/" + in.nextLine();
        File file = new File(filePath);
        if (file.exists()) {
            long bytes = file.length();
            System.out.println("Размер файла в байтах: " + bytes);
        } else {
            System.out.println("Такого файла не обнаружено");
        }
        

    }
}
