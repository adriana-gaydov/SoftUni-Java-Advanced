import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            return n1.compareTo(n2);
        };

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(comparator)
                .forEach(e -> System.out.print(e + " "));
    }
}
