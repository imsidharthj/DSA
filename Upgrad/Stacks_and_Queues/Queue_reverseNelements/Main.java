import java.util.*;

public class Main {
    static Queue<Integer> reverseFirstKElemets(Queue<Integer> q, int k) {
        if (k > q.size() || k <= 0) {
            return q;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            deque.push(q.poll());
        }

        while (!deque.isEmpty()) {
            q.add(deque.pop());
        }

        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }

        return q;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<Integer>();

        int n = scanner.nextInt();
        for (int i=0 ; i<n ; i++) {
            int num = scanner.nextInt();;
            queue.add(num);
        }

        int k = scanner.nextInt();
        queue = reverseFirstKElemets(queue, k);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}