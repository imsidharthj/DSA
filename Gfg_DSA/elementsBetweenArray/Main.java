import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 3, 4};  // Input array
        int[] low = {0, 2};  // Lower bounds of the queries
        int[] high = {2, 4};  // Upper bounds of the queries

        ArrayList<Integer> result = solution.midElements(arr, low, high);
        for (int count : result) {
            System.out.println(count);  // Output the result for each query
        }
    }
}

// arr = [1, 2, 2, 3, 4]
// low = [0, 2]
// high = [2, 4]

class Solution{
    public int binarySearch(int[] arr, int s, boolean leftAlways){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if((leftAlways && arr[mid] < s) || (!leftAlways && arr[mid] <= s)){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left;
    }

    public ArrayList<Integer> midElements(int[] arr, int[] low, int[] high){
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < low.length; i++){
            int left = binarySearch(arr, low[i], true);
            int right = binarySearch(arr, high[i], false);
            res.add(right - left);
        }
        return res;
    }
}