import java.util.Arrays;

class Main{
    Boolean[][]dp;
    public boolean partition(int[] nums, int targetSum, int index){
        if(index == nums.length || targetSum < 0) return false;

        if(targetSum == 0) return true;

        if(dp[index][targetSum] != null) return dp[index][targetSum];

        boolean include = partition(nums, targetSum - nums[index], index + 1);
        boolean exclude = partition(nums, targetSum, index + 1);

        dp[index][targetSum] = include || exclude;
        return dp[index][targetSum];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int targetSum = sum / 2;

        dp = new Boolean[nums.length][targetSum + 1];
        return partition(nums, targetSum, 0);
    }

    public static void main(String[] args) {
        Main obj = new Main();

        int[] nums = {1, 5, 11, 5};
        boolean result = obj.canPartition(nums);

        System.out.println("Can partition: " + result);
    }
}