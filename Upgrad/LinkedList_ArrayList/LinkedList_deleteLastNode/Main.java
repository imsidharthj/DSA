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
        deleteLastNode(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static void deleteLastNode(Node head) {
        if (head == null) return;
        if (head.next == null) {
            Main.head = null;
            return;
        }
        Node last = head;
        Node secondLast = null;
        while(last.next != null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
    }
}
