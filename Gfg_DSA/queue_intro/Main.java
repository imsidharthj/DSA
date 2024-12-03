import java.util.Scanner;

class Main{
    int size = 10;
    int[] queue = new int[size];
    int curSize = 0;
    int start = -1; int end = -1;
    public void pushQueue(int element) {
        if (curSize == size) {
            System.out.println("queue overflow! Cannot push " + element);
            return;
        } 
        if (curSize == 0){
            start = 0; 
            end = 0;
        }
        else {
            end = (end + 1) % size;
        }
        queue[end] = element; 
        curSize ++;
        System.out.println("Pushed: " + element);
    }

    public int topQueue() {
        if (curSize == 0) {
            System.out.println("queue is empty!");
            return -1;
        } else {
            return queue[start];
        }
    }

    public int popQueue() {
        if (curSize == 0) {
            System.out.println("queue underflow! Cannot pop");
            return -1;
        }
        int curElement = queue[start];
        if(curSize == 1){
            start = -1; 
            end = -1;
        }
        else {
            start = (start + 1) % size;
        }
        curSize--;
        System.out.println("Popped: " + queue[start]);
        return curElement;
    }

    public int sizeQueue() {
        return curSize;
    }

    public static void main(String[] args) {
        Main queueObj = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek Front");
            System.out.println("4. Size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to push: ");
                    int element = sc.nextInt();
                    queueObj.pushQueue(element);
                    break;
                case 2:
                    queueObj.popQueue();
                    break;
                case 3:
                    int frontElement = queueObj.topQueue();
                    if (frontElement != -1) {
                        System.out.println("Front Element: " + frontElement);
                    }
                    break;
                case 4:
                    System.out.println("Queue Size: " + queueObj.sizeQueue());
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