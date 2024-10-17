import java.util.Scanner;

class Solution{
    public int findFectorialZeros(int n){
        int result = 0;
        // for (int i = 1; i <= n; i++){
        //     result *= i;
        // }
        // return result;

        // for (int i = 5; i < n; i *= 5){
        //     result += n/i;
        // }
        // return result;

        int divisors = 5;
        while(n >= divisors){
            result += n/divisors;
            divisors *= 5;
        }
        return result;
    }
}

class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number for fectrial's trailing zeros");
        int n = scanner.nextInt();
        int result = solution.findFectorialZeros(n);  // Find trailing zeros
        System.out.println("Trailing zeros in " + n + "! is: " + result);
        scanner.close();
    }
}