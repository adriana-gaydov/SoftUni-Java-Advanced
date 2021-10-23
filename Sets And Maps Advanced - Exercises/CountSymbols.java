import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (char c : input.toCharArray()) {
            if (!countSymbols.containsKey(c)) {
                countSymbols.put(c, 1);
            } else {
                countSymbols.put(c, countSymbols.get(c) + 1);
            }
        }
        countSymbols.entrySet()
                .forEach(e -> System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}
