package OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    public String getName() {
        return name;
    }
}
