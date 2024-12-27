class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Main{
    public boolean isPalindrome(Node head){
        if(head == null) return true;

        Node slow = head;
        Node fast = head;
        Node rev = null;

        while (fast != null && fast.next != null) {
            Node temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;

            rev.next = temp;
        }

        Node tail = (fast != null) ? slow.next : slow;

        while (rev != null) {
            if(rev.data != tail.data){
                return false;
            }
            rev = rev.next;
            tail = tail.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        Main main = new Main();

        boolean result = main.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        result = main.isPalindrome(head2);
        System.out.println("Is the linked list a palindrome? " + result);
    }
}