import java.util.Scanner;

class Main {
    int top = -1;
    int[] stack = new int[10];

    public void pushStack(int element) {
        if (top >= stack.length - 1) {
            System.out.println("Stack overflow! Cannot push " + element);
        } else {
            top++;
            stack[top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    public int topStack() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top];
        }
    }

    public void popStack() {
        if (top == -1) {
            System.out.println("Stack underflow! Cannot pop");
        } else {
            System.out.println("Popped: " + stack[top]);
            top--;
        }
    }

    public int sizeStack() {
        return top + 1;
    }

    public static void main(String[] args) {
        Main stackObj = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek Top");
            System.out.println("4. Size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to push: ");
                    int element = sc.nextInt();
                    stackObj.pushStack(element);
                    break;
                case 2:
                    stackObj.popStack();
                    break;
                case 3:
                    int topElement = stackObj.topStack();
                    if (topElement != -1) {
                        System.out.println("Top Element: " + topElement);
                    }
                    break;
                case 4:
                    System.out.println("Stack Size: " + stackObj.sizeStack());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
