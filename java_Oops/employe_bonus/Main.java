import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Employee{
    private String name;
    private int salary;
    private double bonusPercentage;

    public Employee(){
        this.name = "";
        this.salary = 0;
        this.bonusPercentage = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() { return salary; } // Getter for balance

    public double getBonusPercentage() { return bonusPercentage; }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBonusPercentage(double bonusPercentage){ // Setter for balance
        this.bonusPercentage = bonusPercentage;
    }
    public double calculateBonus(){
        return (bonusPercentage / 100) * salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter Employee Name:");
        employee.setName(scanner.nextLine());
        System.out.println("Enter Salary:");
        employee.setSalary(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Bonus Percentage:");
        employee.setBonusPercentage(scanner.nextDouble());
        scanner.nextLine();
        double bonus = employee.calculateBonus();
        System.out.println("Bonus Amount: " + bonus);

        scanner.close();
    }
}