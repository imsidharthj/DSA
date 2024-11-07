import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static int largestElement(int[] arr){
        int i = 0;
        int maxi = arr[0];
        while (i < arr.length) {
            if (arr[i] > maxi){
                maxi = arr[i];
            }
            i++;
        }
        return maxi;
    }
    public static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    public static boolean checkSorted(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }
    public static int missingElement(int[] arr){
        // int missing = 0;
        // for (int i = 0; i < arr.length - 1; i++){
        //     if ((arr[i] + 1) != arr[i + 1]){
        //         missing = arr[i] + 1;
        //     }
        // }
        // return missing;
        int n = arr.length;
        int sum = (n * (n + 1))/2;
        int sum2 = 0;
        for (int i = 0; i < n; i++){
            sum2 += arr[i];
        }
        return (sum2 - sum);
    }
    public static void removeDuplicates(int[] arr){
        int n = arr.length;
        // for (int i = 0; i < n; i++){
        //     for(int j = i; j < n; j++){
        //         for(int k = i; k < j; k++){
        //             System.out.println(arr[k]);
        //         }
        //     }
        // }
        int i = 0; int j = i + 1;
        while (i < n && j < n) {
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
        for(int k = i + 1; k < n; k++){
            arr[k] = 0;
        }
    }
    public static void leftRotateArrayOnePlace(int[] arr){
        int n = arr.length; int temp = arr[0];
        for (int i = 0; i < n - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }
    public static void leftRotateArrayDplaces(int[] arr, int places){
        int n = arr.length;
        int[] tempArrayList = new int[places];
        for(int i = 0; i < places; i++){
            tempArrayList[i] = arr[i];
        }
        for(int i = places; i < n; i++){
            arr[i - places] = arr[i];
        }
        int temp = 0;
        for(int i = (n - places); i < n; i++){
            arr[i] = tempArrayList[temp];
            temp++;
        }
        // for (int i = 0; i < places; i++) {
        //     arr[n - places + i] = tempArray[i];
        // }
    }
    public static void siftZeors(int[] arr){
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] != 0){
                arr[temp] = arr[i];
                temp++;
            }
        }
        for(int i = temp; i < n; i++){
            arr[i] = 0;
        }
    }
    public static void printSubarrays(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.print("{");
                for (int k = i; k < j; k++) {
                    System.out.print(arr[k]);
                    if (k < j - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");
            }
        }
    }

    public static void main(String[] args) {
        // int[] arr3 = {10, 20, 30, 40, 50};
        // int secondLargest = secondLargest(arr3);
        // System.out.println("Second Largest: " + secondLargest);
        // int[] arr = {1, 2, 3, 5};
        // int missing = missingElement(arr);
        // System.out.println("Missing Element: " + missing);
        // int[] arr2 = {1, 2, 3, 4};
        // printSubarrays(arr2);
        // int[] arr4 = {1, 2, 3, 4, 5};
        // boolean isSorted = checkSorted(arr4);
        // System.out.println("Is Sorted: " + isSorted);
        // int[] arr = {1, 1, 2, 2, 3, 4, 4};
        // removeDuplicates(arr);
        // System.out.println(Arrays.toString(arr));
        // int[] arr = {1, 2, 3, 4, 5};
        // int n = 2;
        // leftRotateArrayDplaces(arr, n);
        // System.out.println(Arrays.toString(arr));
        int [] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        siftZeors(arr);
        System.out.println(Arrays.toString(arr));
    }
}