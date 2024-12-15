import java.util.HashMap;

class Main{
    public static int fibonachi(int n, int[] dp){

        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fibonachi(n - 1, dp) + fibonachi(n - 2, dp);
    }

    public static int fibonachiItrately(int n){
        int dp[] = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int minStep(int n, HashMap<Integer, Integer> dp, int[] cost){
        if(n <= 1) return 0;

        if(dp.containsKey(n)){
            return dp.get(n);
        }

        int stepOne = (n - 1 >= 0 ? cost[n - 1] : 0) + minStep(n - 1, dp, cost);
        int stepSecond = (n - 2 >= 0 ? cost[n - 2] : 0) + minStep(n - 2, dp, cost);
        int minCost = Math.min(stepOne, stepSecond);

        dp.put(n, minCost);
        return minCost;
    }

    public static void main(String[]args){
        // int n = 10;
        // int[] dp = new int[n + 1];
        // dp[0] = 0; dp[1] = 1;
        // for(int i = 2; i <= n; i++){
        //     dp[i] = -1;
        // }
        // int result = fibonachi(n, dp);
        // int result = fibonachiItrately(n);
        // System.out.println("Fibonacci of " + n + " is " + result);

        HashMap<Integer,Integer> dp = new HashMap<>();
        int[] cost = {10, 15, 20};
        int n = cost.length;
        int result = minStep(n, dp, cost);
        System.out.println(result);
    }
}