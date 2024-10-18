public class Main {
    public static boolean checkBitLeft(int n, int i) {
        return ((n & (1 << i)) != 0);
    }

    public static boolean checkBitRight(int n, int i) {
        return (((n >> i) & 1) != 0);
    }

    public static boolean setBit(int n, int i){
        if ((n | (1 << i)) != 0){
            return true;
        }
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
        if ((n & n - 1) == 0){
            return true;
        } else {
            return false;
        }
    }

    public static int countBits(int n){
        int count = 0;
        while(n > 1){
            if (n % 2 == 0){
                // count++;
                // n /= 2;
                count += n & 1;
                n = n >> 1;
            }
        }
        if (n == 1){
            count += 1;
        }
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
        int n = 13; // Binary: 1010
        int i = 2;
        System.out.println(checkBitLeft(n, i));  // True
        System.out.println(checkBitRight(n, i)); // True
    }
}