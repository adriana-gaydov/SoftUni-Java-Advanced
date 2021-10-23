import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] text = bf.readLine().split("\\s+");

        List<String> capitalLetters = Arrays.stream(text)
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(capitalLetters.size());
        capitalLetters.forEach(System.out::println);
    }
}
