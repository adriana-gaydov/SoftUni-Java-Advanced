import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .min().orElse(0));

     //   Function<int[], Integer> getMin = array -> Arrays.stream(array).min().orElse(0);
    }
}
