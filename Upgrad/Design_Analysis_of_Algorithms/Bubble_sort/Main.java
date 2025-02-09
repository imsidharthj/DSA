import java.util.*;

class Main{
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n - i; j++){
                if(arr[j - 1] > arr[j]){
                    swap(j -1, j, arr);
                }
            }
        }
    }

    static void swap(int i, int j, int [] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // public static void main(String[] args){
    //     int [] arr = {5, 4, 8, 1, 7, 3};
    //     bubbleSort(arr);
    //     System.out.println(Arrays.toString(arr));
    // }

    public static void main(String[] args) {
        System.out.println("Enter the no. of elements :");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = 0;
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array :");
        for (i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        for (i = 0; i < n; i++) {
            int swap = 0;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) {
                    break;
                }
        }
        
        System.out.println("sorted array ");
        for (i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}