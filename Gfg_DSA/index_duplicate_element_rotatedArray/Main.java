public class Main {
    public static void main(String[] args) {
        Generate generate = new Generate();
        int[] arr = {3, 4, 5, 6, 7, 1, 2, 2, 2, 3, 3};
        int k = 7;
        
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
    public int countOccurence(int[] arr, int l, int h, int k, boolean isFirst) {
        // int l = 0;
        // int h = n - 1;
        int result = -1;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == k) {
                result = mid;
                if (isFirst) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
            // // If the left half is sorted
            // else if (arr[l] <= arr[mid]) {
            //     if (arr[l] <= k && k < arr[mid]) {
            //         h = mid - 1;  // Search left side
            //     } else {
            //         l = mid + 1;  // Search right side
            //     }
            // } 
            // // If the right half is sorted
            // else {
            //     if (arr[mid] < k && k <= arr[h]) {
            //         l = mid + 1;  // Search right side
            //     } else {
            //         h = mid - 1;  // Search left side
            //     }
            // }
        }
        return result;
    }

    public int minElement(int []arr){
        int l = 0;
        int h = arr.length - 1;
        // int ans = Integer.MAX_VALUE;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
        
            if(arr[l] < arr[h]){
                return l;
                // ans = Math.min(ans, arr[l]);
                // break;
            } else if (arr[l] <= arr[mid]) {
                // ans = Math.min(ans, arr[l]);
                l = mid + 1;
            }  else {
                // ans = Math.min(ans, arr[mid]);
                h = mid;
            }
        }
        return l;
    }

    public int[] leftRightSearch(int[] arr, int n, int k) {
        int minIndex = minElement(arr);
        int first = -1, last = -1;

        first = countOccurence(arr, minIndex, n - 1, k, true); // Search in the right side of the rotated array 
        if (first == -1) {
            first = countOccurence(arr, 0, minIndex - 1, k, true); 
        }

        last = countOccurence(arr, 0, minIndex - 1, k, false); // Search in the left side of the rotated array 
        if (last == -1) {
            last = countOccurence(arr, minIndex, n - 1, k, false); 
        }
        
        if (first > last) {
            int temp = first;
            first = last;
            last = temp;
        }
        
        if (first == -1 || last == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }
}
