import java.util.Scanner;

public class timus1493 {
    public static void main(String[] args) {
        System.out.println("Введите номер билета: ");
        Scanner in = new Scanner(System.in);
        String ticketNumber = in.nextLine();

        if (nextOrPrevIsLucky(ticketNumber)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean nextOrPrevIsLucky(String ticketNumber) {
        int ticketNum = Integer.parseInt(ticketNumber);
        int ticketNumNext = ticketNum + 1;
        int ticketNumPrev = ticketNum - 1;

        return isLucky(ticketNumNext) || isLucky(ticketNumPrev);
}

    public static boolean isLucky(int ticketNum) {
        String ticketStr = String.format("%06d", ticketNum);
        int leftSum = (ticketStr.charAt(0) - '0') + 
                    (ticketStr.charAt(1) - '0') + 
                    (ticketStr.charAt(2) - '0');

        int rightSum = (ticketStr.charAt(3) - '0') + 
                    (ticketStr.charAt(4) - '0') + 
                    (ticketStr.charAt(5) - '0');

        return leftSum == rightSum;

}
}
