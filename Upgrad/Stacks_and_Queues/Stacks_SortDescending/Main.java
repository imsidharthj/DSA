import java.util.*;

public class Main {
   public static Stack < Integer > sortStack(Stack < Integer > input) {
       Stack<Integer> temp = new Stack<>();
       while(!input.isEmpty()){
           int top = input.pop();
           while(!temp.isEmpty() && temp.peek() > top){
               input.push(temp.pop());
           }
           temp.push(top);
       }
       return temp;
   }

   public static void findKthLargestNum(Stack <Integer> sortedStack, int k) {
    //   System.out.println(sortedStack);
    //   int count = 1;
    //   while(!sortedStack.isEmpty()){
    //     int Kth = sortedStack.pop();
    //     if(count == k){
    //         System.out.println(Kth);
    //         return;
    //     }
    //     count++;
    //   }
        for(int i = 0; i < k - 1; i++){
            sortedStack.pop();
        }
        System.out.println(sortedStack.pop());
   }


  public static void main(String args[]) {
        Stack < Integer > inputStack = new Stack < Integer > ();
        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        for (int i = 0; i < n; i++) {
            inputStack.add( in .nextInt());
        }

        if (inputStack.isEmpty()) {
            System.out.println("stack is empty");
            System.exit(0);
        }

        int k = in .nextInt();
        if (k > inputStack.size()) {
            System.out.println("invalid input");
            System.exit(0);
        }

        Stack < Integer > temp = sortStack(inputStack);
        findKthLargestNum(temp, k);
    }
}
