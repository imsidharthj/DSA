import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        solution.gcd(arr);

        scanner.close();
    }
}

class Solution{
    public void gcd(int[] arr) {
        // Find factors for each number
        ArrayList<Integer>[] factors = new ArrayList[arr.length];
        for (int i = 0; i < arr.length; i++) {
            factors[i] = new ArrayList<>();
            for (int j = 1; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    factors[i].add(j);
                }
            }
        }

        ArrayList<Integer> commonFactors = factors[0];
        for (int i = 1; i < factors.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int factor : commonFactors) {
                if (factors[i].contains(factor)) {
                    temp.add(factor);
                }
            }
            commonFactors = temp;
        }
        System.out.println("Common factors: ");
        for (int factor : commonFactors) {
            System.out.print(factor + " ");
        }
        int gcd = Collections.max(commonFactors);
        System.out.println("\nGCD: " + gcd);
    }
}