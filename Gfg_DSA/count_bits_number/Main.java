import java.util.Scanner;

public class Main{
    public int[] countBits(int n){
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++){
            int count = 0;
            int num = i;
            while(num > 0){
                // num = num % 2;
                // count++;
                // num = num / 2;
                count += num & 1;
                num = num >> 1;
            }
            if (num == 1){
                count ++;
            }
            arr[i] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number n to calculate the bit counts from 0 to n:");
        int n = scanner.nextInt();
        int[] result = main.countBits(n);
        System.out.println("The count of bits from 0 to " + n + " are:");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " -> " + result[i] + " bits");
        }
        scanner.close();
    }
}