import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        int[] validKeysResult = solution.validKeys(arr);
        System.out.println("Number of valid keys for each number:");
        System.out.println(Arrays.toString(validKeysResult));
        scanner.close();
    }
}

class Solution{
    // there is cyber security firm has discovered new type of encription used by hackers 
    // ecription key will be valid key which is excatly fectors or divisors 
    // for example 4 is the valid keys which are exactly 3 fetors
    // n = [5, 11] (square of prime numbers are valid keys)
    public int[] validKeys(int[] arr){
        int n = Arrays.stream(arr).max().getAsInt();
        int[] result = new int[arr.length];
        int[] count = new int[n + 1];
        Boolean prime[] = new Boolean[n + 1];

        // for (int i = 0; i < n; i++){
        //     prime[i] = true;
        // }
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        Arrays.fill(count, 0);

        for (int i = 2; i * i < n; i++){
            if(prime[i] == true){
                for (int j = i * i; j <= n; j += i){
                    prime[j] = false;
                }
            }
            // count[i] = count[i - 1] + prime[i];
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] && i * i <= n) {
                count[i * i] ++;
            }
        }

        for (int i = 1; i <= n; i++){
            count[i] += count[i - 1];
        }

        for (int i = 0; i < arr.length; i++){
            result[i] = count[arr[i]];
        }
        return result;
    }
}