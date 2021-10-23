package CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Cat> cats  = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            Cat cat = null;
            switch (inputArgs[0]) {
                case "Siamese":
                cat = new Siamese(inputArgs[1], Double.parseDouble(inputArgs[2]));
                break;
                case "Cymric":
                    cat = new Cymric(inputArgs[1], Double.parseDouble(inputArgs[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(inputArgs[1], Double.parseDouble(inputArgs[2]));
                    break;
            }
            cats.put(inputArgs[1], cat);
            input = sc.nextLine();
        }
        String name = sc.nextLine();
        System.out.println(cats.get(name));
    }
}
