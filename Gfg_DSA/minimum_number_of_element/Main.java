import java.util.Arrays;

class Main {
    public static int minElements(int n, int m, int[] arr1, int[] arr2) {
        // code here
        int arr1Sum = 0;
        for(int i = 0; i < arr1.length; i++){
            arr1Sum += arr1[i];
        }
        Arrays.sort(arr2);
        reverseArray(arr2);
        int minCount = 0;
        int currentSum = 0;
        for(int j = 0; j < arr2.length; j++){
            // int currentSum += arr2[j];
            // mincCount++;
            // if(currentSum > arr1Sum){
            //     return minCount;
            // }
            if(currentSum >= arr1Sum){
                // currentSum += arr2[j];
                // minCount ++;
                break;
            }
            currentSum += arr2[j];
            minCount++;
        }
        if(currentSum >= arr1Sum){
            return minCount;
        } else {
            return -1;
        }
    }
    
    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[]args){
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {4, 3, 1, 5, 2};
        int n = arr1.length;
        int m = arr2.length;
        int result = minElements(n, m, arr1, arr2);
        System.out.println(result);
    }
}