import java.util.*;

class Main {
    private double length;
    private double width;

    public Main(){ // constructor name should be same as class name
        this.length = 0;
        this.width = 0;
    }
    public void setLength(double length){ // Setter for length
        this.length = length;
    }
    public void setWidth(double width){ // Setter for width
        this.width = width;
    }
    public double calculateArea(){
        return this.length * this.width;
    }
    public double calculatePerimeter(){
        return (this.length + this.width) * 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        Main list = new Main();
        list.setLength(length);
        list.setWidth(width);
        double area = list.calculateArea();
        double perimeter = list.calculatePerimeter();
        System.out.println("Area :" + area);
        System.out.println("Perimeter :" + perimeter);
    }
}