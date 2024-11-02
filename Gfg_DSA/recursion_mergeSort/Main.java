class Main{
    public static void mergeSort(int[] arr, int low, int high){
        int mid = (low + high) / 2;
        if(low >= high){
            return;
        }
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        // for(int i = low; i < high; i++){
        //     arr[i] = temp[i - low];
        // }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        mergeSort(arr, 0, arr.length - 1); // Adjusted high index
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}