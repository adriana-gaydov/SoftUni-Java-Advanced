package PetClinics;

public class Pet implements Comparable<Pet> {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }

    @Override
    public int compareTo(Pet o) {
        if (this.name.equals(o.name)) {
            if (this.age == o.age) {
                return this.kind.compareTo(o.kind);
            }
            return Integer.compare(this.age, o.age);
        }
        return this.name.compareTo(o.name);
    }
}
