import java.io.File;
import java.io.IOException;

public class example1 {
    public static void main(String[] args) {
        // Создание меню
        File folder = new File("code/files/example1/example_file.txt");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " +
                    folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " +
                    folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " +
                folder.getAbsolutePath());
        }

        // Создание файла внутри папки
        File file = new File(folder.getAbsolutePath() +
            File.separator);
        file = new File(file, "example_file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать файл: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        // Удаление файла и папки
        if (file.delete()) {
            System.out.println("Файл удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
    }
}
