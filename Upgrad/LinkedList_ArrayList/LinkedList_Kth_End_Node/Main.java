import java.util.*;

public class Main {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        head = null;
        if (n > 0) {
            head = new Node(s.nextInt());
            Node temp = head;
            for (int i = 1; i < n; i++) {
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }
        }
        int k = s.nextInt();
        kthNodeFromEnd(k, head);
    }

    static void kthNodeFromEnd(int k, Node head) {
        Node slow = head;
        Node fast = head;
        
        for(int i = 0; i < k; i++){
            if(fast == null){
                System.out.println("Not Possible");
                return;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }
}
