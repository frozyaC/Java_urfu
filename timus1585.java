import java.util.Scanner;

public class timus1585 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();

        int[] penguins = new int[3];

        String[] penguinsName = new String[3];
        penguinsName[0] = "Emperor Penguins";
        penguinsName[1] = "Little Penguins";
        penguinsName[2] = "Macaroni Penguins";


        for (int i = 0; i < N; i++) {
            switch (in.nextLine()) {
                case "Emperor Penguin" -> penguins[0]+=1;
                case "Little Penguin" -> penguins[1]+=1;
                case "Macaroni Penguin" -> penguins[2]+=1;
            }
        }

        int penguinMaxIndex = 0;
        int penguinMaxCount = penguins[0];

        for (int i = 1; i < 3; i++) {
            if (penguinMaxCount < penguins[i]) {
                penguinMaxCount = penguins[i];
                penguinMaxIndex = i;
            }
        }

        System.out.println("\nAnswer is: " + penguinsName[penguinMaxIndex]);
    }
}
