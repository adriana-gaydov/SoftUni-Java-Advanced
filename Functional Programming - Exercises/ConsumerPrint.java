import java.util.Arrays;
import java.util.Scanner;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(System.out::println);
    }
}
