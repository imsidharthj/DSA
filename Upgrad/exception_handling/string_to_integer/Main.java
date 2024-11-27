import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to convert to an integer:");
        String input = scanner.nextLine(); // Use nextLine() to allow for empty input

        try {
            if (input.isEmpty()) {
                throw new NullPointerException("Input string is empty.");
            }

            try {
                int output = Integer.parseInt(input);
                System.out.println("Converted integer: " + output);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. The string cannot be parsed as an integer.");
            }
        } catch (NullPointerException e) {
            System.out.println("Error: No input provided. The string is empty.");
        } finally {
            scanner.close();
        }
    }
}
