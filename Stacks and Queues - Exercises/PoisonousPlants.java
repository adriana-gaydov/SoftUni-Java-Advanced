import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PoisonousPlants2 {public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    String[] input = reader.readLine().split("\\s+");
    int[] plants = new int[n];
    for (int i = 0; i < n; i++) {
       plants[i] = Integer.parseInt(input[i]);
    }
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    int count = 0;

    do {
        for (int i = 0; i < plants.length - 1; i++) {
            long left = plants[i];
            long right = plants[i + 1];

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
            plants[m] = -1;
        }

        stack.clear();



    } while (true);





}
}
