import java.util.Arrays;
import java.util.Scanner;

public class KnightOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(n -> "Sir " + n)
                .forEach(System.out::println);
    }
}
