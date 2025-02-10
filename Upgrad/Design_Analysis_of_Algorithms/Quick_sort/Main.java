import java.util.*;

 class Source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        quickSort(arr, 0, n - 1);
        for (String s : arr) {
            System.out.println(s);
        }
    }

   public static void quickSort(String array[], int left, int right) {
       if (left < right) {
           int position = partition(array, left, right);
           quickSort(array, left, position - 1);
           quickSort(array, position + 1, right);
       }
   }

    static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].length() < pivot.length()) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}