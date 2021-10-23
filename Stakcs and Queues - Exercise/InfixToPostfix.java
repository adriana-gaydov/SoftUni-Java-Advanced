import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<String> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> bracket = new ArrayDeque<>();
        String[] tokens = input.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                operators.push(s);
            } else if (s.equals("(")) {
                bracket.push(s);
            } else if (s.equals(")")) {
                if (!bracket.isEmpty() && i + 1 != tokens.length) {
                    String numberTwo = numbers.pollLast();
                    String numberOne = numbers.pollLast();
                    System.out.print(numberOne + " " + numberTwo + " " + operators.pop() + " ");
                }
            } else {
                numbers.offer(s);
            }
        }

        numbers.forEach(e -> System.out.print(e + " "));
        operators.forEach(e -> System.out.print(e + " "));
    }
}
