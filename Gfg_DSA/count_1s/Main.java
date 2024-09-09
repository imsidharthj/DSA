import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0){
		   
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    
		    Solution obj = new Solution();
		    System.out.println(obj.countOnes(arr, n));
		    
		}
		
	}
}

class Solution{
    // public static int countOnes(int arr[], int N){
    //     int l = 0;
    //     int h = N - 1;
    //     while (l <= h){
    //         int mid = (l + h)/ 2;
    //         if (arr[mid] == 1){
    //             l = mid + 1;
    //         }
    //         else
    //             h = mid - 1;
    //     }
    //     return h + 1;
        
    // }

    public static int countOnes(int arr[], int N){
        return countOnes(arr, 0, N - 1);
    }
    public static int countOnes(int arr[], int l, int h) {
        if (l > h) {
            return 0;
        }

        int mid = (l + h) / 2;

        if (arr[mid] == 1) {
            return (mid - l + 1) + countOnes(arr, mid + 1, h); // Count ones in the right half and add 1 for the current one
        } else {
            return countOnes(arr, l, mid - 1); // Search the left half
        }
    }
}