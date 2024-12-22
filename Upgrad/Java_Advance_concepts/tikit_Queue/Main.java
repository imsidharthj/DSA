import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.LinkedList;
import java.util.Queue;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Main {
    static class TicketQueue {
        private Queue<String> queue;

        public TicketQueue() {
            this.queue = new LinkedList<>();
        }

        public void enqueueRequest(String customerName) {
            queue.add(customerName);
        }

        public String dequeueRequest() {
            return queue.poll();
        }

        public boolean hasRequests() {
            return !queue.isEmpty();
        }
    }
    
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);
        TicketQueue ticketQueue = new TicketQueue();
        System.out.print("Enter the number of customer requests: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the customer requests:");
        for (int i = 0; i < n; i++) {
            String customerName = scanner.nextLine();
            ticketQueue.enqueueRequest(customerName);
        }
        System.out.print("Enter the number of requests to remove: ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("Removed requests: ");
        for (int i = 0; i < m; i++) {
            String removedRequest = ticketQueue.dequeueRequest();
            if (removedRequest != null) {
                System.out.print(removedRequest + " ");
            } else {
                System.out.print("(None) ");
            }
        }
        System.out.println();
        System.out.println("Has requests? " + ticketQueue.hasRequests());
        scanner.close();
	}
}