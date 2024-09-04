import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}

class Solution
{
    static int majorityElement(int a[], int size)
{
    int majority = a[0];
    int count = 1;
    for (int i = 1; i < a.length; i++){
        if (a[i] == majority){
            count++;
        } else {
            count--;
            if (count == 0){ //If the count becomes 0, it means that the current majority is no longer a potential majority element
                majority = a[i]; //majority is updated to the current element a[i]
                count = 1; //count is reset to 1
            }
        }
    }
    // Check if the majority element occurs more than n/2 times
    count = 0;
    for (int i = 0; i < a.length; i++){
        if (a[i] == majority){
            count++;
        }
    }
    return count > size/2 ? majority : -1;
}
}