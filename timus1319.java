import java.util.Scanner;

public class timus1319 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] letterShell = new int[N][N]; 

        int i = N;
        int j = -1;
        int number = 0;
        while (N > 0) {
            i-=1;
            j+=1;
            number+=1;
            letterShell[i][j] = number;
        }
        for (int i = N; i > 0; i--) {
            for (int j = N; j > 0; j--) {
                letterShell[i][j] = 
            }
        }
    }

}
