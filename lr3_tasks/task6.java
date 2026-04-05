import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class task6 {
    private static int solveWithArrayList(int n) {
        List<Integer> people = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    private static int solveWithLinkedList(int n) {
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    public static void main(String[] args) {
        int n = 30000;

        long startArray = System.nanoTime();
        int survivorArray = solveWithArrayList(n);
        long arrayMs = (System.nanoTime() - startArray) / 1_000_000;

        long startLinked = System.nanoTime();
        int survivorLinked = solveWithLinkedList(n);
        long linkedMs = (System.nanoTime() - startLinked) / 1_000_000;

        System.out.println("N = " + n);
        System.out.println("ArrayList: остался человек №" + survivorArray + ", время: " + arrayMs + " мс");
        System.out.println("LinkedList: остался человек №" + survivorLinked + ", время: " + linkedMs + " мс");

        if (arrayMs < linkedMs) {
            System.out.println("Быстрее: ArrayList");
        } else if (linkedMs < arrayMs) {
            System.out.println("Быстрее: LinkedList");
        } else {
            System.out.println("Обе реализации показали одинаковое время");
        }
    }
}
