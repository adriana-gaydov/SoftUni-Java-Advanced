import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = array -> Arrays.stream(array)
                .map(n -> n += 1).toArray();
        Function<int[], int[]> multiply = array -> Arrays.stream(array)
                .map(n -> n *= 2).toArray();
        Function<int[], int[]> subtract = array -> Arrays.stream(array)
                .map(n -> n -= 1).toArray();
        Consumer<int[]> print = array -> Arrays.stream(array)
                .forEach(e -> System.out.print(e + " "));

        String command = sc.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = sc.nextLine();
        }
    }
}
