
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("code/files/task3/input.txt"));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        System.out.println("Количество строк: " + lineCount);
    }
}
