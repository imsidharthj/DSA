import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        int[] queue = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            int value = scanner.nextInt();
            queue[i] = value;
        }

        dequeue(queue);

        if (queue[0] != 0) {
            for (int i = 0; i < numElements-1; i++) {
                System.out.print(queue[i] + " ");
            }
        }
    }
    
    public static void dequeue(int[] queue) {
        if (queue[0] == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        for (int i = 0; i < queue.length - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[queue.length - 1] = 0;
    }
}