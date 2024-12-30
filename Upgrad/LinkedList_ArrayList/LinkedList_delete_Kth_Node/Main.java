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
        int index = s.nextInt();
        deleteNodeAtGivenIndex(index, head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static void deleteNodeAtGivenIndex(int index, Node head) {
        Node remove = head;
        int count = 1;
        while(remove.next != null && count < index - 1){
            remove = remove.next;
            count ++;
        }
        if (remove.next == null && count != index) {
            return;
        }
        remove.next = remove.next.next;
    }
}
