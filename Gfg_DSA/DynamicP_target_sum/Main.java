import java.lang.reflect.Array;
import java.util.Arrays;

class Main{
    int total;
    public int calculate(int[] nums, int i, int sumTillNow, int targetSum, int[][]memo){
        if(i == nums.length){
            if(sumTillNow == targetSum){
                return 1;
            } else {
                return 0;
            }
        } else {
            if(memo[i][sumTillNow + total] != Integer.MIN_VALUE){
                return memo[i][sumTillNow + total];
            }
            int add = calculate(nums, i + 1, sumTillNow + nums[i], targetSum, memo);
            int subtarct = calculate(nums, i + 1, sumTillNow - nums[i], targetSum, memo);
            memo[i][sumTillNow + total] = add + subtarct;
            return memo[i][sumTillNow + total];
        }
    }

    public int findTargetSumWays(int[] nums, int targetSum){
        total = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * total + 1];
        for(int[] row : memo){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, targetSum, memo);
    }

    public static void main(String[] args){
        Main obj = new Main();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int result = obj.findTargetSumWays(nums, target);
        System.out.println("Number of ways to achieve target: " + result);
    }
}