import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void permute1(int[] arr, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute1(arr, l + 1, r);
                swap(arr, l, i); // backtrack
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void generatePermutations(int[] nums, ArrayList<Integer> tempList, boolean[] used, ArrayList<ArrayList<Integer>> resuList) {
        if (tempList.size() == nums.length) {
            resuList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // Skip if already used
            used[i] = true;
            tempList.add(nums[i]);
            generatePermutations(nums, tempList, used, resuList);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // permute(arr, 0, arr.length - 1);
        ArrayList<ArrayList<Integer>> result = permute(arr);
        System.out.println("All permutations: " + result);
    }
}