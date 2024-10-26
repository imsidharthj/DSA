class Main{
    public static void printNtimes(int n, int i){
        if (i > n){
            return;
        }
        System.out.println("abc");
        printNtimes(n, i+1);
    }
    public static void print1ToN(int n, int i ){
        if (i > n){
            return;
        }
        System.out.println(i);
        print1ToN(n, i+1);
    }
    public static void printNto1(int n){
        if(n <= 0){
            return;
        }
        System.out.println(n);
        printNto1(n - 1);
    }
    public static void backtrack(int i, int n){
        if (i > n){
        return;
        }
        backtrack(i+1, n);
        System.out.println(i);
    }
    public static int sumNnumbers(int n){
        // if(i < 1){
        //     System.out.println(n);
        //     return;
        // }
        // sumNnumbers(i - 1, n + i);
        if(n == 0){
            return 0;
        }
        return n + sumNnumbers(n - 1);
    }
    public static int[] reverseArray(int[] arr, int i, int j){
        // int[] arr2 = new int[arr.length];
        // int i = 0; int j = arr.length - 1;
        // for(; i < arr.length && j >= 0; i++, j--){
        //     arr2[i] = arr[j];
        // }
        // return arr2;
        if (i >= j){
            return arr;
        }
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return reverseArray(arr, i +1, j-1);
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }
    public static void main(String [] args){
        int n = 3;
        // printNtimes(n, 1);
        // print1ToN(n, 1);
        // printNto1(n);
        // backtrack(1, n);
        // int sum = sumNnumbers(n);
        // System.out.println(sum);
        // int[] arr = {1, 2, 3, 4, 5};
        // reverseArray(arr, 0, arr.length - 1);
        // for (int num : arr) {
        //     System.out.print(num + " ");
        // }
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}