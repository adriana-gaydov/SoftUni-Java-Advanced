import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(childrenQueue::offer);
        int n = Integer.parseInt(sc.nextLine());

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n ; i++) {
                String currentChild = childrenQueue.peek();
                childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            System.out.printf("Removed %s%n", childrenQueue.poll());
        }
        System.out.printf("Last is %s%n", childrenQueue.peek());
    }
}
