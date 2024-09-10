import java.util.*;
import java.io.*;

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        boolean[] isPresent = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0 && arr[i] <= size) {
                isPresent[arr[i]] = true;
            }
        }
        for (int i = 1; i <= size; i++) {
            if (!isPresent[i]) {
                return i;
            }
        }
        return size + 1;
    }
}

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}
