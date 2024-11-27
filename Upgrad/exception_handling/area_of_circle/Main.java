import java.util.Scanner;

class NegativeRadiusException extends Exception {
    public NegativeRadiusException(String message) {
        super(message);
    }
}

class Main {
    public static double calculateArea(double radius) throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius cannot be negative.");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius of the circle:");
        try {
            if (!scanner.hasNextDouble()) {
                throw new NumberFormatException("Invalid input. Please enter a valid number.");
            }

            double radius = scanner.nextDouble();
            double area = calculateArea(radius); // Call the method to calculate area
            System.out.println("Area of the circle: " + area);
        } catch (NegativeRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
