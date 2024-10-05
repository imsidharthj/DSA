import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            Solution.Pair p = new Solution().findRepeating(arr, n);

            System.out.println(p.x + " " + p.y);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Pair Class
    static class Pair {
        long x;
        long y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to find repeated element and its frequency.
    public static Pair findRepeating(long arr[], int n) {
        // Your code here
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                long count = 2;
                int j = i + 2;
                while (j < n && arr[j] == arr[i]) {
                    count++;
                    j++;
                }
                return new Pair(arr[i], count);
            }
        }
    return new Pair(-1L, -1L);
    }
};