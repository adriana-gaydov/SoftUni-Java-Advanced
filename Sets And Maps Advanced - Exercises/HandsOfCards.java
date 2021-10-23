import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("JOKER")) {
            String[] inputArgs = input.split(": ");
            String name = inputArgs[0];

            playersCards.putIfAbsent(name, new LinkedHashSet<>());
            playersCards.get(name).addAll(Arrays.asList(inputArgs[1].split(", ")));

            input = sc.nextLine();
        }

        playersCards.entrySet().forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), getCardsPoints(e.getValue()));
        });
    }

    private static int getCardsPoints(Set<String> value) {
        int points = 0;
        Map<Character, Integer> staticMap = getPointsStaticMap();

        for (String card: value) {
            int current = 0;
            if (card.contains("10")) {
                char type = card.charAt(2);
                current = 10 * staticMap.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                current = staticMap.get(power) * staticMap.get(type);
            }
            points += current;
        }
        return  points;
    }

    private static Map<Character, Integer> getPointsStaticMap() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);
        map.put('S', 4);
        map.put('H', 3);
        map.put('D', 2);
        map.put('C', 1);
        return map;
    }
}
