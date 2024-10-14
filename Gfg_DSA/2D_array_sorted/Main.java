public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
            {3, 4, 7, 9},
            {12, 13, 16, 18},
            {20, 21, 23, 29},
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
    public static Pair findKey(int[][] arr, int key) {
        int n = arr.length;
        int m = arr[0].length;
        int l = 0;
        int h = (n * m) - 1;
        while (l <= h){
            int mid = (l + h)/2;
            int row = mid/m; int column = mid % m;
            if (arr[row][column] == key){
                return new Pair(row, column);
            } else if (arr[row][column] > key){
                h = mid - 1;
            } else{
                l = mid + 1;
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