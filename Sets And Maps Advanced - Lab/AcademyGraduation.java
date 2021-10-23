import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim();
            double[] scores = Arrays.stream(sc.nextLine().split("\\s+"))
                                .mapToDouble(Double::parseDouble)
                                .toArray();
            students.put(name, scores);
        }

        students.entrySet().forEach(e -> {
            System.out.printf("%s is graduated with %s%n", e.getKey(), new DecimalFormat("#.################").format(getAverage(e.getValue())));
        });
    }

    private static double getAverage(double[] value) {
        double result = 0;
        for (double d : value) {
            result += d;
        }
        return  result / value.length;
    }
}
