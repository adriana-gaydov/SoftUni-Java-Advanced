package CompanyRoster;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Department> departmentMap = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String name = inputArgs[0];
            double salary = Double.parseDouble(inputArgs[1]);
            String position = inputArgs[2];
            String department = inputArgs[3];

            Employee employee;
            if (inputArgs.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (inputArgs.length == 6) {
                String email = inputArgs[4];
                int age = Integer.parseInt(inputArgs[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                try {
                    int age = Integer.parseInt(inputArgs[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = inputArgs[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalary = departmentMap.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: "  + maxAverageSalary.getName());
        maxAverageSalary.getEmployees()
                .stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
