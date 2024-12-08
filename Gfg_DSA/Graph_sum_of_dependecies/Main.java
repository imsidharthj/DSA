import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            N = Integer.parseInt(read.readLine());
            M = Integer.parseInt(read.readLine());
            int[][] edges = new int[M][2];
            for (int i = 0; i < M; i++) {
                String S[] = read.readLine().split(" ");
                x = Integer.parseInt(S[0]);
                y = Integer.parseInt(S[1]);
                edges[i][0] = x;
                edges[i][1] = y;
            }
            Solution ob = new Solution();
            System.out.println(ob.sumOfDependencies(N, edges));
            System.out.println("~");
        }
    }
}

class Solution {
    int sumOfDependencies(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        
        for(int i=0; i<V; i++){
            g.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        
        for(int[] edge: edges){
            
            g.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++; 
        }
        
        int count = 0;
        
        for(int i=0; i<V; i++){
            count += indegree[i];
        }
        
        return count;
    }
};