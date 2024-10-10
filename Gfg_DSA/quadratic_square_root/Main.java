import java.util.Scanner;

class Solution {

    public int isPalindrome(int N) {
        int original = N;
        int reverse = 0;
        while (N > 0) {
            int number = N % 10;
            reverse = reverse * 10 + number;
            N /= 10;
        }
        
        if (original == reverse) {
            return 1; // It's a palindrome
        } else {
            return -1; // Not a palindrome
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input from the user
        System.out.print("Enter a number to check if it's a palindrome: ");
        int N = scanner.nextInt();
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Call the isPalindrome method and print the result
        int result = solution.isPalindrome(N);
        
        if (result == 1) {
            System.out.println(N + " is a palindrome.");
        } else {
            System.out.println(N + " is not a palindrome.");
        }
        
        scanner.close();
    }
}
