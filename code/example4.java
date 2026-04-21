import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class example4 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Random random = new Random();

    List<Integer> integers = new ArrayList<>();
    
    for (int i = 0; i < 10; i++) {
        integers.add(random.nextInt(50));
    }

    List<Integer> integersAfter = squareNumbers(integers);

    for (int i = 0; i < integersAfter.size(); i++) {
        System.out.println(integers.get(i) + " -> " + integersAfter.get(i));
    }
}

    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}
