import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}


class Solution {
    static int maxStep(int arr[]) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if ((arr[i]) == arr[i + 1]){
                count ++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
        // int c = 0;
        // int m = 0;
        // for (long i = 1; i < arr.length; i++) {
        //     if (arr[(int)i] > arr[(int)i - 1]) c++;
        //     else {
        //         m = Math.max(c, m);
        //         c = 0;
        //     }
        // }
        // m = Math.max(c, m);
        // return m;
        
    //     int l = 0;
    //     int h = arr.length - 1;
    //     int count = 0;
    //     int maxCount = 0;
    //     while (l <= h){
    //         int mid = (l + h)/2;
    //         if (mid < h && arr[mid] + 1 == arr[mid + 1]){
    //             count++;
    //             l = mid + 1;
    //         } else {
    //             maxCount = Math.max(maxCount, count);
    //             count = 0;
    //             if (mid > 0 && arr[mid] > arr[mid - 1]){
    //                 h = mid - 1;
    //             } else {
    //                 l = mid + 1;
    //             }
    //         }
    //     }
    // return Math.max(maxCount, count);
    }
}

