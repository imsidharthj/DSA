// package Gfg_DSA.prime_number;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find all primes up to: ");
        int n = scanner.nextInt();
        Solution solution = new Solution();
        boolean[] primes = solution.findPrimes(n);
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}

class Solution{
    public boolean[] findPrimes(int n){
        boolean prime[] = new boolean[n + 1];
        for (int i = 1; i < n; i++){
            prime[i] = true;
        }
        for (int j = 2; j * j <= n; j++){
            if (prime[j] == true){
                for (int k = j * j; k < n; k += j){
                    prime[k] = false;
                }
            }
        }
        return prime;
    }
}