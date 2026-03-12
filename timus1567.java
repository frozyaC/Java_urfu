import java.util.Scanner;

public class timus1567 {
public static void main(String[] args) {

    int price = 0;

    Scanner in = new Scanner(System.in);

    String text;
    text = in.nextLine();

    for (int i = 0; i < text.length(); i++) {
        switch (text.charAt(i)) {
            case 'a', 'd', 'g', 'j', 'm', 'p', 's', 'v', 'y', '.', ' ' -> price+=1;
            case 'b', 'e', 'h', 'k','n', 'q', 't', 'w', 'z', ',' -> price +=2;
            case 'c', 'f', 'i', 'l', 'o', 'r', 'u', 'x', '!' -> price +=3;
        }
    }

    System.out.println(price);
    


}
}
