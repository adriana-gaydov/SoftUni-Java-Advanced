package Exam_23October2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> madeCocktails = new TreeMap<>();
        madeCocktails.put("Pear Sour", 0);
        madeCocktails.put("The Harvest", 0);
        madeCocktails.put("Apple Hinny", 0);
        madeCocktails.put("High Fashion", 0);

        ArrayDeque<Integer> queueIngredients = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);

        while (!queueIngredients.isEmpty() && !stackFreshness.isEmpty()) {
                int ingredient = queueIngredients.peek();
                int freshness = stackFreshness.peek();
                int freshnessLevel = ingredient * freshness;

                if (ingredient == 0) {
                    queueIngredients.poll();
                    continue;
                }

                if (freshnessLevel == 150) {
                    madeCocktails.put("Pear Sour", madeCocktails.get("Pear Sour") + 1);
                    queueIngredients.poll();
                    stackFreshness.pop();
                } else if (freshnessLevel == 250) {
                    madeCocktails.put("The Harvest", madeCocktails.get("The Harvest") + 1);
                    queueIngredients.poll();
                    stackFreshness.pop();
                } else if (freshnessLevel == 300) {
                    madeCocktails.put("Apple Hinny", madeCocktails.get("Apple Hinny") + 1);
                    queueIngredients.poll();
                    stackFreshness.pop();
                } else if (freshnessLevel == 400) {
                    madeCocktails.put("High Fashion", madeCocktails.get("High Fashion") + 1);
                    queueIngredients.poll();
                    stackFreshness.pop();
                } else {
                    stackFreshness.pop();
                    queueIngredients.poll();
                    queueIngredients.addLast(ingredient + 5);
                }
        }

        if (madeCocktails.containsValue(0)) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }

        if (!queueIngredients.isEmpty()) {
            System.out.printf("Ingredients left: %d%n", queueIngredients.stream().mapToInt(e -> e).sum());
        }
        madeCocktails.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }
}
