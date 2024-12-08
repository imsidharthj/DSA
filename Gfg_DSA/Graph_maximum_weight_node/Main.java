import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int exits[] = new int[n];
            for (int i = 0; i < n; i++) exits[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            System.out.println(sln.maxWeightCell(exits));
            System.out.println("~");
        }
    }
}

class Solution {
    public int maxWeightCell(int[] exits) {
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        int v = exits.length;
        
        for(int i=0; i<v; i++){
            g.add(new ArrayList<>());
        }
        int indegree[]  = new int[v];
        
        for(int i=0; i<v; i++){
            
            if(exits[i] != -1){
                g.get(i).add(exits[i]);
                indegree[exits[i]]++;
            }
        }
        
        
        int maxi = Integer.MIN_VALUE;
        int highestIndex = Integer.MIN_VALUE;
        
        for(int i=0; i<v; i++){
            
            if(maxi <= indegree[i]){
                maxi = indegree[i];
                highestIndex = i;
            }
        }
        
        
        
        // for(int i=0; i<v; i++){
            
        //     System.out.println(indegree[i]);
        // }
        return maxi == Integer.MIN_VALUE? v-1: highestIndex;
    }
}