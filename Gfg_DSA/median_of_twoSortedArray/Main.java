import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n,m;
		    n=sc.nextInt();
		    m=sc.nextInt();
		    
		    int arr[]=new int[n];
		    int brr[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    
		    for(int i=0;i<m;i++)
		    {
		        brr[i]=sc.nextInt();
		    }
		    
		     if(n < m)
	        System.out.println(new Solution().findMedian(arr, n, brr, m));
	         else
	        System.out.println(new Solution().findMedian(brr, m, arr, n));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the median of the two arrays when they get merged.
    public static int findMedian(int arr[], int n, int brr[], int m)
    {
        ArrayList<Integer> combined_list = new ArrayList<>();

        // Add elements from the first array
        for (int i = 0; i < n; i++) {
            combined_list.add(arr[i]);
        }
        for (int j = 0; j < m; j++) {
            combined_list.add(brr[j]);
        }
        Collections.sort(combined_list);
        int combined_length = n + m;
        if (combined_length % 2 == 1) {
            return combined_list.get(combined_length / 2);
        } else {
            int mid1 = combined_list.get((combined_length / 2) - 1);
            int mid2 = combined_list.get(combined_length / 2);
            return (mid1 + mid2) / 2; // Return the floor of the average
        }
    }
}