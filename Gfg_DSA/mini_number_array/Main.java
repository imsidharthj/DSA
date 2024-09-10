import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}

class Solution
{
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        // int min = arr[0];
        // for (int i = 1; i < arr.length; i++){
        //     if (min > arr[i]){
        //         min = arr[i];
        //     }
        // }
        // return min;
        if (low >= high){
            return arr[low];
        }
        int mid = (low + high)/2;
        int leftMin = minNumber(arr, low, mid);
        int rightMin = minNumber(arr, mid + 1, high);
        return Math.min(leftMin, rightMin);
    }
}