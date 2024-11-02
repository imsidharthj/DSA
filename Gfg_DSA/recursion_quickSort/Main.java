import java.util.Arrays;

class Main{
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int partitionElement = sort(arr, low, high);
            quickSort(arr, low, partitionElement - 1);
            quickSort(arr, partitionElement + 1, high);
        }
    }
    public static int sort(int[] arr, int low, int high){
        int partitionElement = arr[low];
        int left = low + 1; int right = high;
        while (left <= right) {
            while (arr[left] <= partitionElement && left <= high) {
                left++;
            }
            while (arr[right] > partitionElement && right >= low) {
                right--;
            }
            if(left < right){
                swap(arr, left, right);
            }
        }
        swap(arr, low, right);
        return right;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int [] arr = {4, 3, 5, 7, 2, 1, 6, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}