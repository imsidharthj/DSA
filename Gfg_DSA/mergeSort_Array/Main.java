public class Main {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 9, 2, 2};
        int[] arr2 = {1, 10, 8, 19, 21, 4};

        int[] sortedArr1 = mergeSort(arr1, 0, arr1.length - 1);
        int[] sortedArr2 = mergeSort(arr2, 0, arr2.length - 1);

        int[] mergedArr = merge(sortedArr1, sortedArr2);

        for (int num : mergedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] {arr[left]};
        }

        int mid = (right + left) / 2;
        int[] leftSorted = mergeSort(arr, left, mid);
        int[] rightSorted = mergeSort(arr, mid + 1, right);

        return merge(leftSorted, rightSorted);
    }
}