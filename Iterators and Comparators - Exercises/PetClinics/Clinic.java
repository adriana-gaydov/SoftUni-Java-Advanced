package PetClinics;

import java.util.Arrays;

public class Clinic implements Comparable<Clinic>{
    private int numberOfRooms;
    private String name;
    private Pet[] pets;

    public Clinic(String name, int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.pets = new Pet[numberOfRooms];
    }

    public boolean add(Pet p) {

        int middleRoom = numberOfRooms / 2;

        for (int i = 0; i <= middleRoom; i++) {
            if (pets[middleRoom - i] == null) {
                pets[middleRoom - i] = p;
                return true;
            } else if (pets[middleRoom + i] == null) {
                pets[middleRoom + i] = p;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int middleRoom = numberOfRooms / 2;

        for (int i = middleRoom; i < pets.length; i++) {
            if (pets[i] != null) {
                pets[i] = null;
                return true;
            }
        }
        for (int i = 0; i < middleRoom; i++) {
            if (pets[i] != null) {
                pets[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        return Arrays.stream(pets).anyMatch(p -> p == null);
    }

    public void print() {
        for (Pet p : pets) {
            if (p == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(p);
            }
        }
    }

    public void print(int room) {
        String out = pets[room - 1] == null
                ? "Room empty"
                : pets[room - 1].toString();
        System.out.println(out);
    }

    @Override
    public int compareTo(Clinic o) {
       if (this.name.equals(o.name)) {
           return Integer.compare(this.numberOfRooms, o.numberOfRooms);
       }
       return this.name.compareTo(o.name);
    }
}
