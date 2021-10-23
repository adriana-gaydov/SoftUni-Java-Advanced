import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] range = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String criteria = bf.readLine();
        Predicate<Integer> predicate = (criteria.equals("even"))
                                        ? n -> n % 2 == 0
                                        : n -> n % 2 != 0;

        printNumbersIn(range[0], range[1], predicate);

    }

    private static void printNumbersIn (int startInclusive, int endInclusive, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(startInclusive, endInclusive)
                .boxed()
                .filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
