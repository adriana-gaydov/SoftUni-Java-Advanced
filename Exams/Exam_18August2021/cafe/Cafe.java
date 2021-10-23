package Exam_18August2021.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() >= capacity) {
            return;
        }
        this.employees.add(employee);
    }

    public boolean removeEmployee(String name) {
        Employee employeeToRemove = getEmployee(name);
        if (employeeToRemove != null) {
            this.employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Employee getOldestEmployee() {
        return this.employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder(String.format("Employees working at Cafe %s:%n", name));
        this.employees.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }
}
