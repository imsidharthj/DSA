import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Vehicle {
    protected String make;
    protected String model;

    public Vehicle(String make, String model){
        this.make = make;
        this.model = model;
    }

    public void displayDetails(){
        System.out.println("Make:" + make);
        System.out.println("Model:" + model);
    }
}
class Car extends Vehicle{
    private int numDoors;

    public Car(String make, String model, int numDoors){
        super(make, model); // Call Vehicle's constructor
        this.numDoors = numDoors;
    }

    @Override
    public void displayDetails() { // Override displayDetails to include number of doors
        super.displayDetails(); // Call parent class's method
        System.out.println("Number of Doors:" + numDoors);
    }
}
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 4);
        car.displayDetails();
    }
}