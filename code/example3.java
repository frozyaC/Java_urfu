import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        String fileName = "code/files/example3/example_file.txt";
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
            System.out.println("Данные записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл " + fileName);
        }


        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла" + fileName);
        }

        if (new File(fileName).delete()) {
            System.out.println("Файл удален" + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
    }
}
