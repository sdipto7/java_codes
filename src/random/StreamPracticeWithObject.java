package random;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamPracticeWithObject {

    public static void main(String[] args) {
        List<Employee> employeeList = getEmployees();

        //Printing the Employee Object using forEach()
        System.out.println("Employee List: ");
        employeeList.forEach(System.out::println);
        lineBreak();

        //Printing the names of employee using map() and forEach()
        System.out.println("Employee names: ");
        employeeList.stream().map(employee -> employee.getName()).forEach(System.out::println);
        lineBreak();

        //Printing the employee names whose experience is greater or equal to 3 years
        System.out.println("Employees with 3 or more years of experience: ");
        employeeList.stream()
                .filter(employee -> employee.getYearsOfExperience() >= 3)
                .map(Employee::getName)
                .forEach(System.out::println);
        lineBreak();

        //Printing the employee names whose experience is less than 3 years
        System.out.println("Employees with less than 3 years of experience: ");
        employeeList.stream()
                .filter(employee -> employee.getYearsOfExperience() < 3)
                .map(Employee::getName)
                .forEach(System.out::println);
        lineBreak();

        //Printing the employee names and salaries whose salary is greater than 5000.00
        System.out.println("Employees whose salary is greater than $5000.00: ");
        employeeList.stream()
                .filter(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(5000.00)) == 1)
                .map(employee -> "Employee name: " + employee.getName() + "\nSalary: " + employee.getSalary())
                .forEach(System.out::println);
        lineBreak();

        //Printing the employee names and salaries whose salary is less or equal to 5000.00
        System.out.println("Employees whose salary is less than or equal to $5000.00: ");
        employeeList.stream()
                .filter(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(5000.00)) == -1
                        || employee.getSalary().compareTo(BigDecimal.valueOf(5000.00)) == 0)
                .map(employee -> String.format("Employee name: %1$s\nSalary: %2$.2f", employee.getName(), employee.getSalary()))
                .forEach(System.out::println);
        lineBreak();

        //Sum of salaries of all employees
        BigDecimal sumOfSalary = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(String.format("Total salary: %1$.2f", sumOfSalary));
        lineBreak();

        //Maximum salary of an employee
        BigDecimal maxSalary = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::max);
        System.out.println(String.format("Maximum salary: %1$.2f", maxSalary));
        lineBreak();

        //Minimum salary of an employee
        Optional<BigDecimal> minSalary = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal::min);
        System.out.println(String.format("Minimum salary: %1$.2f", minSalary.get()));
        lineBreak();

        //Sum of salaries of all employees who has more than 3 years of experience
        BigDecimal sumOfSalaryWithMoreExperience = employeeList.stream()
                .filter(employee -> employee.getYearsOfExperience() > 3)
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(String.format("Total salary of employees with more than 3 years of experience: %1$.2f", sumOfSalaryWithMoreExperience));
        lineBreak();

        //Sum of salaries of all employees who has less than or equal to 3 years of experience
        Optional<BigDecimal> sumOfSalaryWithLessExperience = employeeList.stream()
                .filter(employee -> employee.getYearsOfExperience() < 3 || employee.getYearsOfExperience() == 3)
                .map(Employee::getSalary)
                .reduce(BigDecimal::add);
        System.out.println(String.format("Total salary of employees with less than or equal to 3 years of experience: %1$.2f", sumOfSalaryWithLessExperience.get()));
        lineBreak();

        //Printing the experience year of the most experienced employee
        System.out.println(String.format("Maximum Experience an employee has: %1$d",
                employeeList.stream()
                        .map(Employee::getYearsOfExperience)
                        .max(Integer::compareTo).get()));
        lineBreak();

        //Printing the experience year of the least experienced employee
        Integer minExperienceYear = employeeList.stream()
                .map(Employee::getYearsOfExperience)
                .min(Integer::compareTo)
                .get();
        System.out.println(String.format("Minimum Experience an employee has: %1$d", minExperienceYear));
    }

    public static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Shahriar", 2, new BigDecimal("5000.00")));
        employeeList.add(new Employee(2, "Rumi", 1, new BigDecimal("4000.00")));
        employeeList.add(new Employee(3, "Dipto", 7, new BigDecimal("12000.00")));
        employeeList.add(new Employee(4, "Fahim", 5, new BigDecimal("9000.00")));
        employeeList.add(new Employee(5, "Sheikh", 3, new BigDecimal("5500.00")));

        return employeeList;
    }

    public static void lineBreak() {
        System.out.println("=======================================");
    }
}

class Employee {

    private long id;

    private String name;

    private int yearsOfExperience;

    private BigDecimal salary;

    public Employee() {
    }

    public Employee(long id, String name, int yearsOfExperience, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                '}';
    }
}