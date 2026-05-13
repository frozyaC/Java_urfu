import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class task7 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = in.nextLine();
        String filePath = "code/files/task7/" + fileName;
        File file = new File(filePath);
        if (file.exists() == false) {
            file.createNewFile();
            System.out.println("Файл создан: " + filePath);
        }
        FileWriter writer = new FileWriter(filePath);
        System.out.println("Введите текст для записи в файл: ");
        String data = in.nextLine();
        writer.write(data);
        System.out.println("Данные записаны в файл " + filePath);
        System.out.println("Количество записанных символов: " + data.length());
        writer.close();
    }
}
