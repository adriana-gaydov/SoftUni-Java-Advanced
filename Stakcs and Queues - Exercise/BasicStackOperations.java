import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = sc.nextInt(); //elements to push
        int S = sc.nextInt(); //elements to pop
        int X = sc.nextInt(); //element contains?

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }

        for (int i = 0; i < S; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.contains(X)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
