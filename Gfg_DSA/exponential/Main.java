import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Get input values from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base (a): ");
        double a = scanner.nextDouble();
        System.out.print("Enter the exponent (b): ");
        long b = scanner.nextLong();

        // Calculate the result using the findExponential function
        double result = solution.findExponential(a, b);

        // Print the result
        System.out.println("The result of a^b is: " + result);
    }
}

class Solution{
    public double findExponential(double a, long b){
        // int result = 0;
        // while(b > 0){
        //     result *= a;
        //     b --;
        // }
        double res = 1.0;
        while(b > 0){
            if(((b & 1) != 0) || (b % 2 != 0)){
                res = res * a;
            }
            a = a * a;
            b = b / 2;
        }
        return res;
    }
}