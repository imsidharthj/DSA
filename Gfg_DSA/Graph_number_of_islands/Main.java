class Main{
    public static int numberOfIslands(String[][] matrix){
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j<col; j++){
                if(matrix[i][j].equals("1") && !visited[i][j]){
                    dfs(matrix, visited, i, j, row, col);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(String[][]matrix, boolean[][] visited, int currI, int currJ, int row, int col){
        if(currI < 0 || currJ < 0 || currI >= row || currJ >= col || matrix[currI][currJ].equals("0") || visited[currI][currJ] == true){
            return;
        }

        visited[currI][currJ] = true;

        dfs(matrix, visited, currI, currJ + 1, row, col);
        dfs(matrix, visited, currI, currJ - 1, row, col);
        dfs(matrix, visited, currI + 1, currJ, row, col);
        dfs(matrix, visited, currI - 1, currJ, row, col);
    }
    public static void main(String[] args) {
        String[][] grid = {
            {"1", "1", "1", "1", "0"},
            {"1", "1", "0", "1", "0"},
            {"1", "1", "0", "0", "0"},
            {"0", "0", "0", "0", "0"}
        };

        int result = numberOfIslands(grid);
        System.out.println("Number of islands: " + result);
    }
}