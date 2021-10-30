import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commandArgs = sc.nextLine().split("\\s+");

            switch (commandArgs[0]) {
                case "1":
                    text.append(commandArgs[1]);
                    stack.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(commandArgs[1]);
                    text.delete(text.length() - count, text.length());
                    stack.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (stack.size() > 1) {
                        stack.pop();
                        text = new StringBuilder(stack.peek());
                    } else {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
