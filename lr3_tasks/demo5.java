public class demo5 {
    private static int depth = 0;

    public static void main(String[] args) {
        int n = 10;
        int result = fact(n);
        System.out.println("F(" + n + ") = " + result);
    }

    public static int fact(int n) {
        space();
        System.out.println("-> F(" + n + ")");

        if (n == 0) {
            space();
            System.out.println("<- F(0) = 0 (base)");
            return 0;
        }
        if (n == 1) {
            space();
            System.out.println("<- F(1) = 1 (base)");
            return 1;
        }

        depth++;
        int left = fact(n - 1);
        int right = fact(n - 2);
        depth--;

        int sum = left + right;
        space();
        System.out.println("<- F(" + n + ") = " + sum + " (" + left + " + " + right + ")");
        return sum;
    }

    private static void space() {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }
}