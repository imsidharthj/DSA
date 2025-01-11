import java.util.*;

public class Main {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
       sort(stack);
    }

    // Method to sort the elements of the stack in ascending order
    static void sort(Stack<Integer> stack) {
        // Write your code here
        Stack <Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            int top = stack.pop();
            while(!temp.isEmpty() && temp.peek() < top){
                stack.push(temp.pop());
            }
            temp.push(top);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println(stack);
    }
}