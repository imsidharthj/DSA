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
    public static void main(String [] args){
        int n = 3;
        // printNtimes(n, 1);
        // print1ToN(n, 1);
        // printNto1(n);
        // backtrack(1, n);
        int sum = sumNnumbers(n);
        System.out.println(sum);
    }
}