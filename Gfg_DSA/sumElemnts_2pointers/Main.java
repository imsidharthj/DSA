import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main{
    public static List<List<Integer>> sumElements(int sum, int[] arr){
        // arr = [1, 2, 3, 4, 5, 9, 8, 7]
        // sum = 16
        // Arrays.sort(arr);
        // int[] arr2 = new int[3];
        // for (int k = 0; k < arr.length - 2; k++) {
        //     int i = k + 1;
        //     int j = arr.length - 1;
        //     while (i < j) {
        //         int currentSum = arr[k] + arr[i] + arr[j];
        //         if (currentSum == sum) {
        //             arr2[0] = arr[k];
        //             arr2[1] = arr[i];
        //             arr2[2] = arr[j];
        //             return arr2; // Return the first found triplet
        //         } else if (currentSum < sum) {
        //             i++; // Move the left pointer to increase the sum
        //         } else {
        //             j--; // Move the right pointer to decrease the sum
        //         }
        //     }
        // }
        // return new int[]{};
        Arrays.sort(arr);
        return utilTriplets(arr, sum);
    }

    public static List<List<Integer>> utilTriplets(int[] arr, int sum){
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (i == 0 || arr[i] != arr[i - 1]){
                int start = i + 1;
                int end = n - 1;
                int remining = sum - arr[i];

                while (start < end && start < n && end >= 0) {
                    if (remining == (arr[start] + arr[end])){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(arr[i]);
                        temp.add(arr[start]);
                        temp.add(arr[end]);
                        result.add(temp);

                        while (start < end && arr[start] == arr[start + 1]) {
                            start ++;
                        }
                        while (start < end && arr[end] == arr[start - 1]) {
                            end--;                            
                        }
                        start++;
                        end--;
                    } else if (remining > arr[start] + arr[end]){
                        // while (start < end && arr[start] == arr[start + 1]) {
                        //     start++;
                        // }
                        start++;
                    } else {
                        // while (start < end && arr[end] == arr[start - 1]) {
                        //     end--;
                        // }
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 8, 7};
        int sum = 16;
        List<List<Integer>> result = sumElements(sum, arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}