import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}


class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
  int count = 0,cnt = 0,i,j,curr;
  for(i=0;i<n;i++){
    if(arr[i] == -1)
      continue;
    curr = arr[i];
    count = 0;
    for(j=0;j<n;j++){
      if(curr == arr[j]){
        count++;
        arr[j] = -1;
      }
    }
    if(count > (n/k))
      cnt++;
  }
  return cnt;
    }
}
