import java.util.*;

public class Main {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        printFifthElementFromStart(stack);
    }

    static void printFifthElementFromStart(Stack<Integer> stack) {
        if(stack.size() < 5){
            System.out.println("There are not enough elements in the stack");
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while(stack.size() > 5){
            temp.push(stack.pop());
        }
        System.out.println(stack.peek());
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}