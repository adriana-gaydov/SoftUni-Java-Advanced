import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double[] prices = Arrays.stream(bf.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(p -> p * 1.2)
                .forEach(p -> System.out.printf("%.2f%n", p));
    }
}
