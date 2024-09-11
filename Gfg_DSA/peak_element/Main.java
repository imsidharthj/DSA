import java.util.*;
import java.io.*;
class PeakElement{
	public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
			int n=Integer.parseInt(in.readLine().trim());
			int[] a=new int[n];
		    int[] tmp=new int[n];
		    String s[]=in.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(s[i]);
				tmp[i] = a[i];
			}
		    
		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);
			
			if(A<0 && A>=n)
			    out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    out.println(f);
			}
		}
		out.close();
	}
}

class Solution
{
	public int peakElement(int[] arr, int n) {
    // int l = 0, h = n - 1;

    // while (l <= h) {
    //     int mid = (l + h) / 2;

    //     if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
    //         return mid; // Found a peak
    //     }
    //     if (arr[mid] < arr[mid - 1]) {
    //         h = mid - 1;
    //     } else {
    //         l = mid + 1;
    //     }
    // }
    // return -1;
    return peakElement(arr, 0, n - 1);
    }
    public int peakElement(int[] arr, int l, int h){
        if (l > h){
            return -1;
        }
        int mid = (l + h)/2;
        if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == h || arr[mid] >= arr[mid + 1])){
            return mid;
        } else if (mid > 0 && arr[mid] < arr[mid - 1]){
            return peakElement(arr, l , mid - 1);
        } else {
            return peakElement(arr, mid + 1, h);
        }
    }
}
