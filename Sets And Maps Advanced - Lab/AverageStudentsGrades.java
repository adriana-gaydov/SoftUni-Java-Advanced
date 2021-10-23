import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String name = inputArgs[0];
            double grade = Double.parseDouble(inputArgs[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.forEach((key, value) -> {
            System.out.print(key + " -> ");
            value.forEach(g -> System.out.printf("%.2f ", g));
            System.out.printf("(avg: %.2f)%n", getAverage(value));
        });
    }

    private static double getAverage(List<Double> value) {
        double result = 0;
        for (double v : value) {
            result += v;
        }
        return result / value.size();
    }
}
