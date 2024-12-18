class Main{
    public int longestCommonSubsequence(String text1, String text2){
        int rows = text1.length();
        int cols = text2.length();

        int dp[][] = new int[rows + 1][cols + 1];

        for(int i = 0; i <= rows; i++){
            for(int j = 0; j <= cols; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        Main obj = new Main();
        String text1 = "abcde";
        String text2 = "ace";

        int result = obj.longestCommonSubsequence(text1, text2);
        System.out.println("Length of the longest common subsequence: " + result);
    }
}