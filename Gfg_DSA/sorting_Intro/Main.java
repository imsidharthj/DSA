import java.util.Arrays;

class Main{
    public static void sortArrayBySeletion(int[] arr){
        // int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void sortArrayByBubble(int[] arr){
        int temp = 0; int n = arr.length - 1;
        for(int i = n; i >= 1; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArrayByQuick(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            sortArrayByQuick(arr, low, partitionIndex - 1);
            sortArrayByQuick(arr, partitionIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // j initiate at start of array, i at 1 less than j
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // if value less than pivot is found
                i++; // increse value of i
                swap(arr, i, j); // swap value of i and j
            }
        }
        swap(arr, i + 1, high); // when there be no index less than pivot "swap arr[i + 1] with pivot"
        return i + 1; // return pivot index as partition
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sortArrayByMerge(int[] arr){
        int length = arr.length;
        if(length <= 1){
            return;
        }
        int middle = length / 2;
        int[] arrayOne = new int[middle];
        int[] arrayTwo = new int[length - middle];
        int i = 0; int j = 0;
        for(; i < length; i++){ // splitting the original array arr into two subarrays
            if(i < middle){ // i < middle, it means we're in the first half of the array
                arrayOne[i] = arr[i]; // value at arr[i] is directly copied to arrayOne[i]
            } else {
                arrayTwo[j] = arr[i];  // second half of arr, and now arr[i] should be assigned to arrayTwo.
                j++;
            }
        }
        sortArrayByMerge(arrayOne);
        sortArrayByMerge(arrayTwo);
        merge(arr, arrayOne, arrayTwo);
    }
    public static void merge(int[] arr, int[] arrayOne, int[] arrayTwo){
        int i = 0; int l = 0; int r = 0;
        int lengthOne = arr.length / 2;
        int lengthtwo = arr.length - lengthOne;
        while (l < lengthOne && r < lengthtwo){
            if(arrayOne[l] < arrayTwo[r]){
                arr[i] = arrayOne[l];
                i++;
                l++;
            } else{
                arr[i] = arrayTwo[r];
                i++;
                r++;
            }
        }
        while (l < lengthOne) { // handle any leftover elements in the arrayOne
            arr[i] = arrayOne[l]; // l is less than lengthOne, then this loop will execute and placing any remaining elements of arrayOne into arr
            i++;
            l++;
        }
        while (r < lengthtwo) { // handle any leftover elements in the arraytwo
            arr[i] = arrayTwo[r]; // r is less than lengthtwo, then this loop will execute and placing any remaining elements of arrayTwo into arr
            i++;
            r++;
        }
    }
    public static void main(String[] args){
        int[] arr = {13, 47, 24, 52, 20, 9};
        // sortArrayBySeletion(arr);
        // sortArrayByBubble(arr);
        // sortArrayByQuick(arr, 0, arr.length - 1);
        sortArrayByMerge(arr);
        System.out.println(Arrays.toString(arr));
    }
}