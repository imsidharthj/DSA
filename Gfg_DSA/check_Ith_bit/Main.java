import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static boolean checkBitLeft(int n, int i) {
        return ((n & (1 << i)) != 0);
    }

    public static boolean checkBitRight(int n, int i) {
        return (((n >> i) & 1) != 0);
    }

    public static boolean setBit(int n, int i){
        // if ((n | (1 << i)) != 0){
        //     return true;
        // }
        return (n | (1 << i)) != 0;
    }

    public static int clearBit(int n, int i){
        // if ((n ^ (1 << i)) == 0){
        //     return true;
        // } else if ((n & (1 << i)) == 0){
        //     return true;
        // } else if ((n & ~ (1 << i)) == 0){
        //     return true;
        // }
        int mask = ~(1 << i);
        return n & mask;
    }

    public static boolean checkPowerOfTwo(int n){
        // if ((n & n - 1) == 0){
        //     return true;
        // } else {
        //     return false;
        // }
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int countBits(int n){
        int count = 0;
        while(n > 0){
            // if (n % 2 == 0){
            //     // count++;
            //     // n /= 2;
            //     count += n & 1;
            //     n = n >> 1;
            // }
            count += (n & 1);
            n = n >> 1;
        }
        // if (n == 1){
        //     count += 1;
        // }
        return count;
    }

    public static int countBits_(int n){
        int count = 0;
        while(n != 0){
            n = n & (n -1);
            count ++;
        }
        return count;
    }

    public static int countFlips(int a, int b){
        int answer = a^b;
        int count = 0;
        while (answer != 0) {
            answer = answer & (answer - 1);
            count ++;
        }
        return count;
    }

    public static int minBitFlips(int start, int goal){
        int answer = start ^ goal;
        int count = 0;
        for(int i = 0; i < 31; i++){
            if((answer & (1 << i)) != 0){
                count++;
            }
        }
        return count;
    }

    public static int[][] subSets(int[] arr){
        int numberOfSubsets = (1 << arr.length);
        int[][] result = new int[numberOfSubsets][];
        for(int i = 0; i < numberOfSubsets; i++){
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            for(int j = 0; j < arr.length; j++){
                if((i & (1 << j)) != 0){
                    tempArrayList.add(arr[j]);
                }
            }
            result[i] = tempArrayList.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    public static int singleNumber(int[] arr){
        int number = 0;
        for(int i = 0; i < arr.length; i++){
            number ^= arr[i];
        }
        return number;
    }

    public static int singleNumberOne(int[] arr){
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(numbers.containsKey(arr[i])){
                numbers.put(arr[i], numbers.get(arr[i]) + 1);
            } else {
                numbers.put(arr[i], 1);
            }
        }
        for (var entry : numbers.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int singleNumberTwo(int[] arr){
        int ans = 0;
        for(int i = 0; i < 31; i++){
            int cont = 0;
            for (int j = 0; j < arr.length; j++){
                if((arr[j] & (1 << i)) != 0){
                    cont++;
                }
            }
            if(cont % 3 == 1){
                ans = ans | (1 << i);
            }
        }
        return ans;
    }

    public static int singleNumberThree(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i = i+3){
            if(arr[i] != arr[i + 1] && arr[i] != arr[i + 2]){
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }

    public static int singleNumberFour(int[] arr){
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < arr.length; i++){
            ones = ((arr[i] ^ ones) &~ twos);
            twos = (arr[i] ^ twos) &~ ones;
        }
        return ones;
    }

    public static int[] doubleNumber(int[] arr){
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int rightMost = xor & -xor; // Isolate the rightmost set bit
        int ones = 0, twos = 0;
        for (int j = 0; j < arr.length; j++) {
            if ((arr[j] & rightMost) != 0) {
                ones ^= arr[j];  // XOR elements with the rightmost set bit
            } else {
                twos ^= arr[j];  // XOR elements without the rightmost set bit
            }
        }
        return new int[]{ones, twos};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test checkBitLeft and checkBitRight
        System.out.println("Enter a number n and bit position i for checking bits:");
        int n = scanner.nextInt();
        int i = scanner.nextInt();
        System.out.println("Check bit using left shift (bit " + i + "): " + checkBitLeft(n, i));
        System.out.println("Check bit using right shift (bit " + i + "): " + checkBitRight(n, i));

        // Test setBit
        System.out.println("Set bit at position " + i + ": " + setBit(n, i));

        // Test clearBit
        System.out.println("Clear bit at position " + i + ": " + clearBit(n, i));

        // Test checkPowerOfTwo
        System.out.println("Enter a number to check if it's a power of 2:");
        int powerOfTwoCheck = scanner.nextInt();
        System.out.println("Is " + powerOfTwoCheck + " a power of 2? " + checkPowerOfTwo(powerOfTwoCheck));

        // Test countBits and countBits_
        System.out.println("Enter a number to count set bits:");
        int bitCountNumber = scanner.nextInt();
        System.out.println("Number of set bits (using shift): " + countBits(bitCountNumber));
        System.out.println("Number of set bits (Brian Kernighan's algorithm): " + countBits_(bitCountNumber));

        // Test countFlips
        System.out.println("Enter two numbers to count bit flips:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Number of bit flips to convert " + a + " to " + b + ": " + countFlips(a, b));
        
        int start = 7; int goal = 10;
        int answer = minBitFlips(start, goal);
        System.out.println(answer);

        int[] arr = {1, 2, 3};
        int[][] result = subSets(arr);
        for (int[] subset : result) {
            System.out.print("[");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }

        int[] arr2 = {1, 1, 2, 2, 3, 4, 4};
        int singleNumber = singleNumber(arr2);
        System.out.println(singleNumber);

        int[] arr3 = {5, 1, 1, 1, 3, 3, 3, 5, 5, 4, 6, 6, 6};
        int number = singleNumberThree(arr3);
        System.out.println(number);

        int[] arr4 = {1, 2, 1, 4, 5, 6, 4, 2};
        int[] result2 = doubleNumber(arr4);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}