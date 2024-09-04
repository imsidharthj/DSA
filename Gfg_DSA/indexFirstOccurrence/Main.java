//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int sizeOfArray = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[]= new int[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
              arr[i] = Integer.parseInt(st[i]);
            
            int elementToSearch = Integer.parseInt(read.readLine());
            
            System.out.println(new LeftIndex().leftIndex(sizeOfArray, arr, elementToSearch));
        }
    }
}


// } Driver Code Ends


class LeftIndex{ 

    static int leftIndex(int N, int arr[], int X)
    {
       
       // Your code here
        int l = 0;
        int h = N - 1;
        while(l <= h){
            int mid = (l + h)/2;
            if (arr[mid] == X)
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    h = mid - 1;
            else if (arr[mid] < X)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;
    }
}

