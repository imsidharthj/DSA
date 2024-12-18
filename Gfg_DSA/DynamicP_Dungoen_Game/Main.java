class Main{
    int[][]dp;
    public int countMinimumentergy(int[][] dungeon, int row, int col){
        if(row == dungeon.length - 1 && col == dungeon[0].length - 1){
            return dungeon[row][col] > 0 ? 1 : - dungeon[row][col] + 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if(row == dungeon.length - 1){
            return dp[row][col] = Math.max(1, countMinimumentergy(dungeon, row, col + 1) - dungeon[row][col]);
        }

        if(col == dungeon[0].length - 1){
            return dp[row][col] = Math.max(1, countMinimumentergy(dungeon, row + 1, col) - dungeon[row][col]);
        }

        return dp[row][col] = Math.max(1, Math.min(countMinimumentergy(dungeon, row + 1, col) - dungeon[row][col], 
        countMinimumentergy(dungeon, row, col + 1) - dungeon[row][col]));
    }

    public int calculateMinimumHP(int[][] dungeon){
        int row = dungeon.length;
        int col = dungeon[0].length;

        if(row == 0 || col == 0) return 1;

        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }

        return countMinimumentergy(dungeon, 0, 0);
    }

    public static void main(String[] args) {
        Main obj = new Main();

        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };

        int result = obj.calculateMinimumHP(dungeon);
        System.out.println("Minimum initial health required: " + result);
    }
}