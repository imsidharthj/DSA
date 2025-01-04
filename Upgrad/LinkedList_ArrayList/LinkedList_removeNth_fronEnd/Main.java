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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            int value = s.nextInt();
            ListNode newNode = new ListNode(value);
            
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int m = s.nextInt();
        ListNode result = removeNthFromEnd(head, m);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currrent = head;
        int totalCount = 0;
        while(currrent != null){
            currrent = currrent.next;
            totalCount++;
        }
        int removeIndex = (totalCount - n);
        if (removeIndex == 0) {
            return head.next;
        }
        int removeCount = 0;
        ListNode previous = null;
        ListNode remove = head;
        while(remove != null){
            if(removeCount == removeIndex){
                break;
            }
            previous = remove;
            remove = remove.next;
            removeCount++;
        }
        previous.next = remove.next;
        return head;
    }
} 