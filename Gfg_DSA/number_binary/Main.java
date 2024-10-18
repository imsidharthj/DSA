import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to convert in binary");
        int n = scanner.nextInt();
        String result = solution.numberToBinary(n);
        System.out.println(result);
    }
}

class Solution{
    public String numberToBinary(int n){
        StringBuilder result = new StringBuilder();
        while (n > 0){
            if(n % 2 == 1){
                result.append(1);
            } else {
                result.append(0);
            }
            n /= 2;
        }
        return result.reverse().toString();
    }
}