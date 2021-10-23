import javax.lang.model.type.ArrayType;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            switch (command) {
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "3":
                    if(!stack.isEmpty()) {
                        System.out.println(Collections.max(stack));
                    }
                    break;
                default:
                    int elementToPush = Integer.parseInt(command.split("\\s+")[1]);
                    stack.push(elementToPush);
                    break;
            }
        }
    }
}
