package StrategyPattern;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
