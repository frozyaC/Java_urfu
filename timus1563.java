
import java.util.Scanner;

public class timus1563 {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    in.nextLine();
    int bayanCounter = 0;

    String[] stores = new String[N];
    for (int i = 0; i < N; i++) {
        stores[i] = in.nextLine();
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (stores[i].equals(stores[j])) {
                bayanCounter+=1;
                break;
            }
        }
    }

    System.out.println(bayanCounter);

}
}
