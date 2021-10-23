import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bf.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + Arrays.stream(numbers).sum());
    }
}
