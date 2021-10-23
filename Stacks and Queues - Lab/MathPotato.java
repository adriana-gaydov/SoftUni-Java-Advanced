import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(childrenQueue::offer);
        int cycleCount = 0;
        int n = Integer.parseInt(sc.nextLine());

        while (childrenQueue.size() > 1) {
            cycleCount++;
            for (int i = 1; i < n; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }

            if (isPrime(cycleCount)) {
                System.out.printf("Prime %s%n", childrenQueue.peek());
            } else {
                System.out.printf("Removed %s%n", childrenQueue.poll());
            }
        }
        System.out.printf("Last is %s%n", childrenQueue.peek());
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
