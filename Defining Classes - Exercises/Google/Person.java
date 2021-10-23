package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;
    private List<Pokemon> pokemons;

    public Person(String name, Company company, List<Parent> parents, List<Child> children, Car car, List<Pokemon> pokemons) {
        this.name = name;
        this.company = company;
        this.parents = parents;
        this.children = children;
        this.car = car;
        this.pokemons = pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Person() {
        car  = null;
        name = null;
        company = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(String name) {
        car  = null;
        this.name = name;
        company = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n");
    }
}
