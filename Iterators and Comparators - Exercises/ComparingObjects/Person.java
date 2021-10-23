package ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.equals(o.name)) {
            if (this.age == o.age) {
                return this.town.compareTo(o.town);
            }
            return Integer.compare(this.age, o.age);
        }
        return this.name.compareTo(o.name);
    }
}
