abstract class Vehicle {
    private String model;
    private int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public abstract void displayDetails();
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, int numberOfDoors) {
        super(model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Model: " + getModel() + ", Year: " + getYear());
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String model, int year, double cargoCapacity) {
        super(model, year);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Model: " + getModel() + ", Year: " + getYear());
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String model, int year, boolean hasSideCar) {
        super(model, year);
        this.hasSideCar = hasSideCar;
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    @Override
    public void displayDetails() {
        System.out.println("Model: " + getModel() + ", Year: " + getYear());
        System.out.println("Has Sidecar: " + hasSideCar);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota Camry", 2022, 4);
        Vehicle motorcycle = new Motorcycle("Harley Davidson", 2021, false);
        Vehicle truck = new Truck("Ford F-150", 2020, 2.5);

        Vehicle[] vehicles = {car, motorcycle, truck};

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println();
        }
    }
}