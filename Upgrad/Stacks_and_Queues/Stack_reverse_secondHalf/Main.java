import java.util.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        reverseSecondHalf(stack);
        s.close();
    }

    // Method to reverse the last half of the elements from the bottom of the stack
    static void reverseSecondHalf(Stack<Integer> stack) {
        // Stack <Integer> tempStack = new Stack<>();
        // int start = 0;
        // int end = stack.size() / 2;
        // while(start < end){
        //     tempStack.push(stack.pop());
        //     start++;
        // }
        // // System.out.println(tempStack);
        // Stack<Integer> reverseStack = new Stack<>();
        // while(!tempStack.isEmpty()){
        //     reverseStack.push(tempStack.pop());
        // }
        // // System.out.println(reverseStack);
        // while(!reverseStack.isEmpty()){
        //     stack.push(reverseStack.pop());
        // }
        // System.out.println(stack);

        int size = stack.size();
        int half = size / 2;
        reverse(stack, half);
    }

    // Recursive helper method to reverse the second half of the stack
    static void reverse(Stack<Integer> stack, int count) {
        if (count > 0) {
            int temp = stack.pop(); // Pop the top element
            reverse(stack, count - 1); // Recur for the remaining elements
            insertAtBottom(stack, temp, count - 1); // Insert the element at the bottom of the second half
        }
    }

    // Recursive helper method to insert an element at the bottom of the second half
    static void insertAtBottom(Stack<Integer> stack, int element, int count) {
        if (count == 0) {
            stack.push(element); // Base case: insert the element
        } else {
            int temp = stack.pop(); // Pop the top element
            insertAtBottom(stack, element, count - 1); // Recur to insert the element
            stack.push(temp); // Push the popped element back
        }
    }
}