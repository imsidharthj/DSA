import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        int cyclePosition = scanner.nextInt();
        if (cyclePosition != -1) {
            ListNode cycleNode = head;
            for (int i = 0; i < cyclePosition; i++) {
                cycleNode = cycleNode.next;
            }
            tail.next = cycleNode;
        }
        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected. Start node of the cycle: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // if(slow == fast){
            //     return slow;
            // }
            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}