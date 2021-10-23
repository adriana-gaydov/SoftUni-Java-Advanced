package Exam_23October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person personToRemove = getPerson(name);
        if (personToRemove != null) {
            this.roster.remove(personToRemove);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream()
                .filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    private Person getPerson(String name) {
        return this.roster.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder(String.format("The people in the hotel %s are:%n", name));
        this.roster.forEach(e -> out.append(e).append(System.lineSeparator()));
        return out.toString();
    }
}
