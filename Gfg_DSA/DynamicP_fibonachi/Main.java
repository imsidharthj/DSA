class Main{
    public static int fibonachi(int n, int[] dp){

        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fibonachi(n - 1, dp) + fibonachi(n - 2, dp);
    }

    public static void main(String[]args){
        int n = 10;
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        // dp[0] = 0; dp[1] = 1;
        int result = fibonachi(n, dp);
        System.out.println("Fibonacci of " + n + " is " + result);
    }
}