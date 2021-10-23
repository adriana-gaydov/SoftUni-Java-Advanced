package Exam_19August2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() >= capacity) {
            return;
        }
        data.add(pet);
    }

    public boolean remove(String name) {
        Pet petToRemove = getPet(name);
        if (petToRemove == null) {
            return  false;
        }
        data.remove(petToRemove);
        return true;
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    private Pet getPet(String name) {
        return data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream()
                .max(Comparator.comparing(Pet::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder(String.format("The clinic has the following patients:%n"));
        data.forEach(e -> output.append(e.getName() + " " + e.getOwner()).append(System.lineSeparator()));
        return output.toString();
    }

}
