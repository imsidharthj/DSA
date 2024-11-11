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

    public static void main(String[] args){
        int[] arr = {13, 47, 24, 52, 20, 9};
        // sortArrayBySeletion(arr);
        // sortArrayByBubble(arr);
        sortArrayByQuick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}