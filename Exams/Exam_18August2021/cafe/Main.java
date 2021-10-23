package Exam_18August2021.cafe;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository
        Cafe cafe = new Cafe("Costa", 15);
//Initialize entity
        Employee employee = new Employee("Alexander", 30, "Bulgaria");
//Print cafe.Employee
        System.out.println(employee); // cafe.Employee: Alexander, 30 from Bulgaria

//Add cafe.Employee
        cafe.addEmployee(employee);

//Remove cafe.Employee
        System.out.println(cafe.removeEmployee("cafe.Employee")); //false

        Employee secondEmployee = new Employee("Sara", 24, "UK");
        Employee thirdEmployee = new Employee("Anna", 22, "Germany");

//Add cafe.Employee
        cafe.addEmployee(secondEmployee);
        cafe.addEmployee(thirdEmployee);

        Employee oldestEmployee = cafe.getOldestEmployee();
        Employee employeeStephen = cafe.getEmployee("Sara");
        System.out.println(oldestEmployee); // cafe.Employee: Alexander, 30 from Bulgaria
        System.out.println(employeeStephen); //cafe.Employee: Sara, 24 from UK

        System.out.println(cafe.getCount()); // 3
        System.out.println(cafe.removeEmployee("Anna")); // true

        System.out.println(cafe.report());
//Employees working at cafe.Cafe Costa:
//cafe.Employee: Alexander, 30 from Bulgaria
//cafe.Employee: Sara, 24 from UK

    }
}
