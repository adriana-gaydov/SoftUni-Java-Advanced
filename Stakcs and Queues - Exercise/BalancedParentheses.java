import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char currentSymbol = line.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openingBrackets.push(currentSymbol);
            } else {
                if (openingBrackets.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (!((currentSymbol == ')' && lastOpeningBracket == '(')
                        || (currentSymbol == ']' && lastOpeningBracket == '[')
                        || (currentSymbol == '}' && lastOpeningBracket == '{'))) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
