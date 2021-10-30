import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int N = sc.nextInt(); //elements to push
        int S = sc.nextInt(); //elements to pop
        int X = sc.nextInt(); //element contains?

        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        for (int i = 0; i < S; i++) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        if (queue.contains(X)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
