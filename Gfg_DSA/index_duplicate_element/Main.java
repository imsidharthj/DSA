public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7};
        int k = 2;
        
        int[] result = solution.leftRightSearch(arr, arr.length, k);
        
        if (result[0] != -1 && result[1] != -1) {
            System.out.println("First occurrence of " + k + ": " + result[0]);
            System.out.println("Last occurrence of " + k + ": " + result[1]);
            System.out.println("Number of occurrences: " + (result[1] - result[0] + 1));
        } else {
            System.out.println(k + " not found in the array");
        }
    }
}

class Solution 
{
    // Function to find first or last occurrence of k.
    public int countOccurence(int[] arr, int n, int k, boolean isFirst) 
    {
        int l = 0;
        int h = n - 1;
        int result = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            
            if (arr[mid] == k) {
                result = mid;
                if (isFirst) {
                    h = mid - 1; // Move left to find the first occurrence
                } else {
                    l = mid + 1; // Move right to find the last occurrence
                }
            } else if (arr[mid] > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    
    // Function to find both first and last occurrences.
    public int[] leftRightSearch(int[] arr, int n, int k) {
        int left = countOccurence(arr, n, k, true);  // First occurrence
        int right = countOccurence(arr, n, k, false); // Last occurrence
        
        if (left == -1 || right == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }
}
