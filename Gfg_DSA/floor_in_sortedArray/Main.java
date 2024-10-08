import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]);
            }

            out.println(new Solution().findFloor(arr, n, x));
        }
        out.close();
    }
}

class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int l = 0;
        int h = n - 1;
        int floor = -1;
        while(l <= h ){
            int mid = (l + h)/2;
            if (arr[mid] <= x){
                floor = mid;
                l = mid + 1;
            }
            else
                h = mid - 1;
        } 
        return floor;
    }
}
