import java.util.Scanner;

class Main {
    public static int calculateFactorial(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Error: Factorial is not defined for negative numbers or zero.");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive integer:");
        try {
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            int factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a positive integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
