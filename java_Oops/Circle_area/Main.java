import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Circle{
    private int radius;
    private double area;

    public Circle(){
        this.radius = 0;
        this.area = 0.0;
    }

    public int getRadius() { return radius; }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public void calculateArea(){
        this.area = Math.PI * radius * radius;
    }

    public void displayArea(){
        System.out.println("Area of the circle: " + area);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Circle object
        Circle circle = new Circle();

        // Take radius as input
        System.out.print("Enter the radius of the circle: ");
        int radius = scanner.nextInt();

        // Set the radius and calculate area
        circle.setRadius(radius);
        circle.calculateArea();

        // Display the area
        circle.displayArea();

        scanner.close();
    }
}