import java.util.*;
class Main{
    public static Stack<Integer>merge_stacks(Stack<Integer> stack1, Stack<Integer> stack2){
        Stack<Integer> newStack = new Stack<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && (stack2.isEmpty() || stack1.peek() > stack2.peek())) {
                newStack.push(stack1.pop());
            } else {
                newStack.push(stack2.pop());
            }
        }

        Stack<Integer> reversedStack = new Stack<>();
        while (!newStack.isEmpty()) {
            reversedStack.push(newStack.pop());
        }

        return reversedStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(3);
        stack1.push(1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(4);
        stack2.push(2);

        System.out.println("Stack 1: " + stack1);
        System.out.println("Stack 2: " + stack2);

        Stack<Integer> mergedStack = merge_stacks(stack1, stack2);
        System.out.println("Merged Stack: " + mergedStack);
    }
}