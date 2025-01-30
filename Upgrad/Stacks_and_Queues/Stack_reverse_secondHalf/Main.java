import java.util.*;

public class Main {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        reverseSecondHalf(stack);
    }

    // Method to reverse the last half of the elements from the bottom of the stack
    static void reverseSecondHalf(Stack<Integer> stack) {
        Stack <Integer> tempStack = new Stack<>();
        int start = 0;
        int end = stack.size() / 2;
        while(start < end){
            tempStack.push(stack.pop());
            start++;
        }
        // System.out.println(tempStack);
        Stack<Integer> reverseStack = new Stack<>();
        while(!tempStack.isEmpty()){
            reverseStack.push(tempStack.pop());
        }
        // System.out.println(reverseStack);
        while(!reverseStack.isEmpty()){
            stack.push(reverseStack.pop());
        }
        System.out.println(stack);
    }
}