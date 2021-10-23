import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        List<Integer> evenNumbers = Arrays.stream(line.split(", ")).map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println(evenNumbers.stream().sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
