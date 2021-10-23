import java.util.Scanner;

public class RecursiveFibonacci {
    public static long memorisedFib[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memorisedFib = new long[n + 1];
        System.out.println(getFibonacci(n));
    }

    public static long getFibonacci(int n) {
        if (n <= 1) return 1L;
        if (memorisedFib[n] != 0) return memorisedFib[n];

        return memorisedFib[n] = getFibonacci(n - 1) + getFibonacci(n-2);
    }
}
