public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int key = 29;

        Pair result = solution.findKey(arr, key);

        if (result.x != -1 && result.y != -1) {
            System.out.println("Key found at indices (" + result.x + ", " + result.y + ")");
        } else {
            System.out.println("Key not found in the array");
        }
    }
}

class Solution {
    // Function to search key in a Row wise And Column wise Sorted Array.
    public static Pair findKey(int[][] arr, int key) {
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m - 1;

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (arr[i][j] == key) {
                return new Pair(i, j);
            } else if (arr[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return new Pair(-1, -1);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}