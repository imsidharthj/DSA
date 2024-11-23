import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Main{
    public static void max(int[] arr, int windowSize){
        // int[] arr = {1, 3, -1, 5, 7, 3, 4};
        // int windowSize = 3;
        ArrayList<Integer> tempArray = new ArrayList<>();
        int i = 0;
        int j = windowSize;
        while (j <= arr.length) {
            int max = Integer.MIN_VALUE; // Initialize max for the current window
    
            // Find the maximum in the current window
            for (int k = i; k < j; k++) {
                if (arr[k] > max) {
                    max = arr[k];
                }
            }
            tempArray.add(max); // Add the max value of the current window to the result
            i++; // Move the window
            j++;
        }
        System.out.println(tempArray);
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        int n = nums.length;

        while(i < k){
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i++);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (i < n) {
            res.add(nums[dq.peek()]);
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i++);
        }
        res.add(nums[dq.peek()]);
        int ans[] = res.stream().mapToInt(j -> j).toArray();

        return ans;
    }

    public static void main(String[] args){
        Main solution = new Main();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result));

        max(nums, k);
    }
}