import java.util.*;

class StackNode {
    char data;
    StackNode next;

    public StackNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(char data) {
        StackNode newNode = new StackNode(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        char popped = top.data;
        top = top.next;
        return popped;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static boolean isValid(String str) {
        Stack stack = new Stack();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && c != ')') ||
                    (top == '{' && c != '}') ||
                    (top == '[' && c != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isValid = isValid(input);
        System.out.println("Is valid: " + isValid);

        scanner.close();
    }
}