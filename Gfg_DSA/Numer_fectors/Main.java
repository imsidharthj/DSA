package Gfg_DSA.Numer_fectors;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int n = scanner.nextInt();
        Solution solution = new Solution();
        ArrayList<Integer> factors = solution.findFectors(n);
        
        // Print the factors
        System.out.println("Factors of " + n + " are: " + factors);
        
        scanner.close();
    }
}

class Solution{
    public ArrayList<Integer> findFectors(int n){
        ArrayList <Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                result.add(i);
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }
        return result;
    }
}