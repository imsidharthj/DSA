import java.util.Scanner;

class Main{
    private static void dfs(int[][] matrix, int[] visited, int currI){
        for(int j = 0; j < matrix.length; j++){
            if(matrix[currI][j] == 1 && visited[j] == 0){ 
                visited[j] = 1;
                dfs(matrix, visited, j);
            }
        }
    }

    public static int numberOfProvinces(int[][] matrix){
        int n = matrix.length;
        int[] visited = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(matrix, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = numberOfProvinces(isConnected);
        System.out.println("Number of Provinces: " + result);
    }
}