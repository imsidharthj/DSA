import java.io.*;
import java.util.*;
public class Main{
 
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(s[i]);
            }
            ot.println(new Solution().findGoodPairs(a, n, k));
        }
        ot.close();
    }
  
}

class Solution{
    static long findGoodPairs(int a[], int n, int k){
        // Code your solution here.
        // int i = 0; 
        // int j = 0;
        // int count = 0;
        // while(i < n){
        //     j = i + 1;
        //     while(j < n){
        //         if (a[i] == a[j] && (j - i) >= k){
        //             count++;
        //         }
        //         j++;
        //     }
        //     i++;
        // }
        // return count;
        ArrayList <Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        long count = 0;
        for(int i = 0; i < n; i++){
            int flavor = a[i];
            if(lastIndex.containsKey(flavor)){
                int j = lastIndex.get(flavor);
                if(Math.abs(i - j) >= k){
                    count++;
                }
            }
            lastIndex.put(flavor, i);
        }
        return count;
    }
}