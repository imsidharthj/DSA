import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking testcases
        int T = sc.nextInt();
        while (T-- > 0) {
            
            //creating an object of class Factorial
            Solution obj = new Solution();
            int N;
            
            //taking N
            N = sc.nextInt();
            
            //calling factorial() method 
            //of class Factorial
            System.out.println(obj.factorial(N));
        }
    }
}

class Solution {

    public long factorial(int N) {
        // Your code here
        // long fecto = 1;
        // for (int i = 1; i < N + 1; i++){
        //     fecto = fecto * i;
        // }
        // return fecto;
        if (N == 0 || N == 1) {
            return 1;
        } else {
            return N * factorial(N - 1);
        }
    }
}
