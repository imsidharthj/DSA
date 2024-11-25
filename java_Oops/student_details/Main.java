import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Student{
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() { return name; } // Getter for balance

    public int getAge() { return age; }

    public String getGrade() { return grade; }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 17, "A");
        student.displayDetails();
    }
}