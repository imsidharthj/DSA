import java.util.Scanner;

class Main{
    public static void divideNumbers(int dividend, int divisor) {
        try {
            int quotient = dividend / divisor;
            System.out.println("Quotient: " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the dividend: ");
            int dividend = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the divisor: ");
            int divisor = Integer.parseInt(scanner.nextLine());
            divideNumbers(dividend, divisor);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            System.out.println("Division process completed.");
        }

        scanner.close();
    }
}