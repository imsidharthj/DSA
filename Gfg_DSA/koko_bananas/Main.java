import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 6, 7, 11};
        int hours = 8;

        int result = solution.minimumBananasHour(arr, hours);

        if (result != -1) {
            System.out.println("minimum bananas (" + result + ")");
        } else {
            System.out.println("Key not found in the array");
        }
    }
}

class Solution {
    public int findMax(int[] arr) {
        int maximum = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            maximum = Math.max(maximum, arr[i]);
        }
        return maximum;
    }

    public int calculateHours(int[] arr, int hours){
        int totalH = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            totalH += Math.ceil((double)arr[i] / (double)hours);
        }
        return totalH;
    }

    public int minimumBananasHour(int[] arr, int hours){
        int l = 1, h = findMax(arr);
        while (l <= h) {
            int mid = (l + h)/2;
            int totalH = calculateHours(arr, mid);
            if (totalH <= hours){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // public int Maxbananas(int[] arr, int h){
    //     int start = 0;
    //     int end = Collections.max(arr);

    //     int res = 0;
    //     while(start <= end){
    //         int mid = (start + end) / 2;
    //         int tempHours = 0;
    //         for (int i = 0; i < arr.length; i++){
    //             tempHours += Math.ceil(arr[i]/mid);
    //         }
    //         if(tempHours <= h){
    //             res = tempHours;
    //             end = mid - 1;
    //         } else{
    //             start = mid + 1;
    //         }
    //     }
    //     return res;
    // }
}