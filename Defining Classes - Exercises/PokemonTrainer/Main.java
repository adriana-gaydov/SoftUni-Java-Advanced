package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Tournament")) {
            String[] inputArgs = input.split("\\s+");
            String trainerName = inputArgs[0];
            String pokemonName = inputArgs[1];
            String pokemonElement = inputArgs[2];
            int pokemonHealth = Integer.parseInt(inputArgs[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);
            input = sc.nextLine();
        }

        String command = sc.nextLine();
        while (!command.equals("End")) {
            for (Trainer t : trainers.values()) {
                if (t.getNumberOfElements(command) == 0) {
                    t.loseHealth();
                } else {
                    t.earnBadge();
                }
            }
            command = sc.nextLine();
        }
        trainers.values().stream().sorted((e1, e2) -> Integer.compare(e2.getNumberOfBadges(), e1.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}
