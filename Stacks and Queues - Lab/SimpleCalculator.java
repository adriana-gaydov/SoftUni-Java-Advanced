import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(queue::offer);

        int sum = 0;

        while (queue.size() > 1) {
            int firstNumber = Integer.parseInt(queue.pop());
            String operator = queue.pop();
            int secondNumber = Integer.parseInt(queue.pop());

            if (operator.equals("+")) {
                sum = firstNumber + secondNumber;
                queue.push(sum + "");
            } else if (operator.equals("-")) {
                sum = firstNumber - secondNumber;
                queue.push(sum + "");
            }

        }
        System.out.println(sum);
    }
}
