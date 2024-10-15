import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number (b): ");
        int b = scanner.nextInt();
        Solution solution = new Solution();
        int gcdResult = solution.gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " using subtraction method: " + gcdResult);
        int gcd1Result = solution.gcd1(a, b);
        System.out.println("GCD of " + a + " and " + b + " using modulus method: " + gcd1Result);
        scanner.close();
    }
}

class Solution{
    public int gcd(int a, int b){
        int gcd = 0;
        while(b > 0){
            if(a > b){
                a = a - b;
            } else {
                b = b - a;
            }
            gcd = a;
        }
        return gcd;
    }

    public int gcd1(int a, int b){
        while(a > 0 && b > 0){
            if (b > a){
                b = b % a;
            } else {
                a = a % b;
            }
        }
        return (a == 0) ? b : a;
        // else return b;
    }
}