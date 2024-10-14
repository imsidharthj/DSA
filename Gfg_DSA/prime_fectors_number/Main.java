import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution{
    public boolean[] prime(int n){
        boolean[] primNumbers = new boolean[n + 1];
        for (int i = 2; i <= n; i++){
            primNumbers[i] = true;
        }
        for (int j = 2; j * j <= n; j++){
            if(primNumbers[j] == true){
                for (int k = j * j; k <= n; k += j){
                    primNumbers[k] = false;
                }
            }
        }
        return primNumbers;
    }

    public ArrayList<Integer> fectors(int n){
        ArrayList<Integer> fectorsNumbers = new ArrayList<>();
        for (int i = 1; i * i <= n; i++){
            if(n % i == 0){
                fectorsNumbers.add(i);
                if (i != n/1){
                    fectorsNumbers.add(n/i);
                }
            }
        }
        return fectorsNumbers;
    }

    // public int[] primeFactors(int[] queries) {
    //     int n = Collections.max(queries);
    //     int[] primeFactors = new int[n + 1];
    //     for (int i = 2; i <= n; i++) {
    //         if (primeFactors[i] == 0) {
    //             for (int j = i * i; j <= n; j += i) {
    //                 primeFactors[j] = i;
    //             }
    //         }
    //     }
    
    //     int[] results = new int[queries.length];
    //     for (int i = 0; i < queries.length; i++) {
    //         int num = queries[i];
    //         while (num > 1) {
    //             int factor = primeFactors[num];
    //             results[i]++;
    //             num /= factor;
    //         }
    //     }
    //     return results;
    // }
}

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find all primes fectors of that number");
        int n = scanner.nextInt();
        Solution solution = new Solution();
        boolean[] primes = solution.prime(n);
        ArrayList<Integer> factors = solution.fectors(n);
        System.out.println("Prime factors of " + n + " are:");
        for (int factor : factors) {
            if (primes[factor]) { // Check if the factor is prime
                System.out.print(factor + " ");
            }
        }
        scanner.close();
    }
}