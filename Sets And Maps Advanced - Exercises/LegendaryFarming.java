import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean isObtained = false;
        while (!isObtained) {
            String[] inputArgs = sc.readLine().split("\\s+");

            for (int i = 0; i < inputArgs.length - 1; i+=2) {
                int quantity = Integer.parseInt(inputArgs[i]);
                String material = inputArgs[i + 1].toLowerCase();
                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        keyMaterials.putIfAbsent(material, 0);
                        keyMaterials.put(material, keyMaterials.get(material) + quantity);
                        if (keyMaterials.get(material) >= 250) {
                            System.out.printf("%s obtained!%n", getObtainedItem(material));
                            keyMaterials.put(material, keyMaterials.get(material) - 250);
                            isObtained = true;
                        }
                        break;
                    default:
                        junkMaterials.putIfAbsent(material, 0);
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                        break;
                }
                if (isObtained) {
                     break;
                }
            }
        }
        keyMaterials.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                });
        junkMaterials.entrySet().forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
    }

    private static String getObtainedItem(String material) {
        switch (material) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
        }
        return null;
    }
}
