import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ArrayDeque<Integer> indexesOfOpeningBrackets = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if (currentSymbol == '(') {
                indexesOfOpeningBrackets.push(i);
            } else if (currentSymbol == ')') {
                System.out.println(expression.substring(indexesOfOpeningBrackets.pop(), i + 1));
            }
        }
    }
}
