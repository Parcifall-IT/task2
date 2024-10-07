package practice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Task3 {
    public static void Task() {
        var employees = new ArrayList<Employee>();
        var rand = new Random();
        for (int i = 0; i < 5; i++) {
            var employee = new Employee(
                    "Alex",
                    rand.nextInt(0, 10),
                    "Naumen",
                    rand.nextDouble(0, 1000));
            employees.add(employee);
        }

        employees.stream()
                .sorted(new EmployeeComparator())
                .forEach(System.out::println);
    }
}

class EmployeeComparator implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return a.getSalary().compareTo(b.getSalary());
    }
}

class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
