import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(e -> e.length() <= n)
                .forEach(System.out::println);
    }
}
