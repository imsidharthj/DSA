class Main{
    public int minDistance(String word1, String word2){
        int rows = word1.length();
        int cols = word2.length();

        int[][] dp = new int[rows + 1][cols + 1];

        for(int i = 0; i <= rows; i++){
            for(int j = 0; j <= cols; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        return Math.max(rows, cols) - dp[rows][cols];
    }

    public static void main(String[] args) {
        Main obj = new Main();
        String word1 = "horse";
        String word2 = "ros";

        int result = obj.minDistance(word1, word2);
        System.out.println("Minimum number of operations: " + result);
    }
}