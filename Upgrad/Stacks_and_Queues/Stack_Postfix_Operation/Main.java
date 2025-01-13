import java.util.*;

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static int evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Input expression cannot be empty or null.");
        }
        Stack stack = new Stack();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int number2 = stack.pop();
                int number1 = stack.pop();
                int result = 0;
                switch (c) {
                    case '+':
                        result = number1 + number2;
                        break;
                    case '-':
                        result = number1 - number2;
                        break;
                    case '*':
                        result = number1 * number2;
                        break;
                    case '/':
                        if (number2 == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        result = number1 / number2;
                        break;
                    }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        System.out.println(evaluateExpression(expression));

        scanner.close();
    }
}