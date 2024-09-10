import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}

class Solution {
    long floorSqrt(long n) {
        // if (n == 0 || n == 1) {
        //     return n;
        // }
        // long low = 1, high = n;
        // while (low <= high) {
        //     long mid = (low + high) / 2;
        //     if (mid * mid == n) {
        //         return mid;
        //     } else if (mid * mid > n) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }
        // return high;
        return floorSqrt(0, n, n);
    }
    long floorSqrt(long l, long h, long n){
        if (l > h){
            return h;
        }
        long mid = (l + h) / 2;
        if (mid * mid == n){
            return mid;
        } else if (mid * mid > n){
            return floorSqrt(l, mid - 1, n);
        } else 
            return floorSqrt(mid + 1, h, n);
    }
}
