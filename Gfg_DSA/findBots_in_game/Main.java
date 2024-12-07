import java.io.*;
import java.util.*;
public class Main{

    public static BufferedReader br;
    public static PrintWriter ot;

	public static void main (String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        
        while(t-->0){
            String usernames[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(usernames[0]);
            usernames  = br.readLine().trim().split(" ");
            int ans[] = new Solution().findBots(usernames , n);
            for(int x : ans)
                ot.print(x + " ");
            ot.println();
        }
        ot.close();
    }
     
  
}

class Solution{
    public int[] findBots(String usernames[], int n){
        // int k = 0;
        // int count = 0;
        // ArrayList<Integer> result = new ArrayList<>();
        // while(k < n){
        //     String currentString = usernames[k];
        //     for(int i = 0; i < currentString.length() - 1; i = i ++){
        //         if(currentString.charAt(i) == currentString.charAt(i + 1)){
        //             count++;
        //         }
        //     }
        //     result.add(count);
        //     k++;
        // }
        // int[] primeBots = new int[n];
        // for(int j = 0; j > result.size(); j++){
        //     if(result.get(j) % 2 != 0){
        //         primeBots[j] = 1;
        //     } else {
        //         primeBots[j] = 0;
        //     }
        // }
        // return primeBots;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            if(checkIfBot(usernames[i], usernames[i].length()))
                ans[i] = 1;
        }
        return ans;
    }
    private boolean checkIfBot(String s, int n){
        Set<Character> hs = new HashSet<>();
        for(int i = 0; i < n; i += 2){
            hs.add(s.charAt(i));
        }
        return checkIfPrime(hs.size());
    }
    private boolean checkIfPrime(int n){
        if(n == 1)
            return false;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}