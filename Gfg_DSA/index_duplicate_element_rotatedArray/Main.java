public class Main {
    public static void main(String[] args) {
        Generate generate = new Generate();
        int[] arr = {3, 4, 5, 6, 7, 1, 2, 2, 2, 3, 3};
        int k = 3;
        
        int[] result = generate.leftRightSearch(arr, arr.length, k);
        
        if (result[0] != -1 && result[1] != -1) {
            System.out.println("First occurrence of " + k + ": " + result[0]);
            System.out.println("Last occurrence of " + k + ": " + result[1]);
            System.out.println("Number of occurrences: " + (result[1] - result[0] + 1));
        } else {
            System.out.println(k + " not found in the array");
        }
    }
}

class Generate {
    // Function to find first or last occurrence of k.
    public int countOccurence(int[] arr, int n, int k, boolean isFirst) {
        int l = 0;
        int h = n - 1;
        int result = -1;
        
        while (l <= h) {
            int mid = (l + h) / 2;

            // If element found at mid, record result and keep searching for first or last
            if (arr[mid] == k) {
                result = mid;
                if (isFirst) {
                    h = mid - 1;  // Move left for first occurrence
                } else {
                    l = mid + 1;  // Move right for last occurrence
                }
            }
            // if (arr[mid] == h && arr[mid] == h){
            //     l++;
            //     h--;
            //     continue;
            // }
            // If the left half is sorted
            else if (arr[l] <= arr[mid]) {
                if (arr[l] <= k && k < arr[mid]) {
                    h = mid - 1;  // Search left side
                } else {
                    l = mid + 1;  // Search right side
                }
            } 
            // If the right half is sorted
            else {
                if (arr[mid] < k && k <= arr[h]) {
                    l = mid + 1;  // Search right side
                } else {
                    h = mid - 1;  // Search left side
                }
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
