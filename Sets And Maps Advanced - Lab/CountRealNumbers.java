import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Double, Integer> numberOccurrence = new LinkedHashMap<>();
        double[] values = Arrays.stream(sc.nextLine().split("\\s+"))
                            .mapToDouble(Double::parseDouble)
                            .toArray();

        for (double currentNum : values){
            if (numberOccurrence.containsKey(currentNum)) {
                numberOccurrence.put(currentNum, numberOccurrence.get(currentNum) + 1);
            } else {
                numberOccurrence.put(currentNum, 1);
            }
        }

        numberOccurrence.entrySet().forEach(e -> System.out.printf("%.1f -> %d%n",
                                                    e.getKey(), e.getValue()));
    }
}
