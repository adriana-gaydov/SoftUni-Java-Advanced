import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Double>> shop = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("Revision")) {
            String[] inputArgs = input.split(", ");
            String shopName = inputArgs[0];
            String product = inputArgs[1];
            double price = Double.parseDouble(inputArgs[2]);

            if (shop.containsKey(shopName)) {
                shop.get(shopName).put(product, price);
            } else {
                Map<String, Double> productAndPrice = new LinkedHashMap<>();
                productAndPrice.put(product, price);
                shop.put(shopName, productAndPrice);
            }
            input = sc.nextLine();
        }
        shop.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().forEach(c -> {
                System.out.printf("Product: %s, Price: %.1f%n", c.getKey(), c.getValue());
            });
        });
    }
}
