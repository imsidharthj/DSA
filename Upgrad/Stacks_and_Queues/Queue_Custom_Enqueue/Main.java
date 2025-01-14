import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int QUEUE_SIZE = 5;
        int[] queue = new int[QUEUE_SIZE];
        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        for (int i = 0; i < numElements; i++) {
            int value = scanner.nextInt();
            enqueue(queue, value);
        }
        if (!isFull(queue)) {
            for (int i = 0; i < numElements; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        else {
            for (int i = 0; i < QUEUE_SIZE; i++) {
                System.out.print(queue[i] + " ");
            }
        }
    }

    public static void enqueue(int[] queue, int value) {
        // int size = 0;
        // if(isFull(queue)){
        //     System.out.println("Queue is full. Cannot enqueue" + value);
        //     return
        // } else {
        //     queue[size] = value;
        //     size++;
        // }
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == 0) {
                queue[i] = value;
                return;
            }
        }
        System.out.println("Queue is full. Cannot enqueue " + value);
    }

    public static boolean isFull(int[] queue) {
        for (int i : queue) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}