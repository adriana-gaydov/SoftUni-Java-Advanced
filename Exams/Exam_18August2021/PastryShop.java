package Exam_18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> cookedFood = new LinkedHashMap<>();
        cookedFood.put("Biscuit", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pie", 0);
        cookedFood.put("Pastry", 0);

        ArrayDeque<Integer> queueLiquids = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackIngredients::push);

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int liquid = queueLiquids.peek();
            int ingredient = stackIngredients.peek();
            int sum = liquid + ingredient;

            if (sum == 25) {
                cookedFood.put("Biscuit", cookedFood.get("Biscuit") + 1);
                remove(queueLiquids, stackIngredients);
            } else if (sum == 50) {
                cookedFood.put("Cake", cookedFood.get("Cake") + 1);
                remove(queueLiquids, stackIngredients);
            } else if (sum == 75) {
                cookedFood.put("Pastry", cookedFood.get("Pastry") + 1);
                remove(queueLiquids, stackIngredients);
            } else if (sum == 100) {
                cookedFood.put("Pie", cookedFood.get("Pie") + 1);
                remove(queueLiquids, stackIngredients);
            } else {
                remove(queueLiquids, stackIngredients);
                stackIngredients.push(ingredient + 3);
            }
        }

        printResult(cookedFood, queueLiquids, stackIngredients);
    }

    private static void printResult(Map<String, Integer> cookedFood, ArrayDeque<Integer> queueLiquids, ArrayDeque<Integer> stackIngredients) {
        if (!cookedFood.containsValue(0)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String queueLiquidsStr = queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Liquids left: %s%n", String.join(",", queueLiquidsStr));
        }

        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String stackIngredientsStr = stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Ingredients left: %s%n", String.join(",", stackIngredientsStr));
        }
        cookedFood.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void remove(ArrayDeque<Integer> queueLiquids, ArrayDeque<Integer> stackIngredients) {
        queueLiquids.poll();
        stackIngredients.pop();
    }
}
