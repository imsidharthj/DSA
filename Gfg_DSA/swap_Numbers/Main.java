public class Main{
    // public String numberToBinary(int n){
    //     StringBuilder result = new StringBuilder();
    //     while (n > 0){
    //         if(n % 2 == 1){
    //             result.append(1);
    //         } else {
    //             result.append(0);
    //         }
    //         n /= 2;
    //     }
    //     return result.reverse().toString();
    // }
    public static int[] swapNumbers(int a, int b){
        a = a ^ b;
        b = a ^ b; //=> (a ^ b) ^ b => a
        a = a ^ b; //=> (a ^ b) ^ b => (a ^ b) ^ a => b
        return new int[] {a, b};
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("Original numbers: " + a + ", " + b);
        int[] swapped = swapNumbers(a, b);
        System.out.println("Swapped numbers: " + swapped[0] + ", " + swapped[1]);
    }
}