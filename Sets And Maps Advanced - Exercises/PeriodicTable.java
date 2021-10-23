import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            Collections.addAll(elements, input);
        }
        elements.forEach(e -> System.out.print(e + " "));
    }
}
