import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Long> plants = new ArrayList<>();
        String[] input = reader.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            plants.add(Long.parseLong(input[i]));
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int count = 0;

        do {
            for (int i = 0; i < plants.size() - 1; i++) {
                long left = plants.get(i);
                long right = plants.get(i + 1);

                if (right > left) {
                    stack.push(i + 1);
                }
            }

            if (stack.isEmpty()) {
                System.out.println(count);
                return;
            }
                count++;
            for (int m : stack) {
                plants.remove(m);
            }

            stack.clear();



        } while (true);





    }
}
