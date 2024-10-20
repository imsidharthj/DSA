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

        scanner.close();
    }
}