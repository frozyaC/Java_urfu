import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        // Запись данных в файл
        String fileName = "code/files/example2/example_file.txt";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные для записи в файл: ");
        String data = in.nextLine();
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data.getBytes());
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String readData = new String(buffer, 0, bytesRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Удаление файла
        if (new File(fileName).delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
    }
}
