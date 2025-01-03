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

        head = reverseList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // Write your code here
        // ListNode prev = null;
        // ListNode current = head;
        // ListNode nextTemp = null;
        // while (current != null) {
        //     nextTemp = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = nextTemp;
        // }
        // return prev;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while(current != null){
            stack.push(current);
            current = current.next;
        }
        ListNode newNode = stack.pop();
        ListNode temp = newNode;
        while(!stack.isEmpty()){
            ListNode swap = stack.pop();
            temp.next = swap;
            temp = temp.next;
        }
        temp.next = null;
        return newNode;
    }
} 