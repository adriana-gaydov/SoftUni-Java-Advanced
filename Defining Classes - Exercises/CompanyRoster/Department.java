package CompanyRoster;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0);
    }
}
