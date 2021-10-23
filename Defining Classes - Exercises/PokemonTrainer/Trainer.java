package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private ArrayList<Pokemon> pokemons;

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public int getNumberOfElements(String element) {
        List<Pokemon> t = new ArrayList<>();
        t = pokemons.stream()
                .filter(p -> p.getElement().equals(element))
                .collect(Collectors.toList());
        return t.size();
    }

    public void loseHealth() {
        this.pokemons = (ArrayList<Pokemon>) this.pokemons
                .stream()
                .map(p -> new Pokemon(p.getName(), p.getElement(), p.getHealth() - 10))
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public void earnBadge() {
        numberOfBadges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, numberOfBadges, pokemons.size());
    }
}
