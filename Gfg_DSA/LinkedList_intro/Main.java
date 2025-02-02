// not in contegious location
// size can increse in any location
// head, next, tail
// used in stack
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Main{
    public static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static void printLinkedList(Node head) {
        int count = 0;
        Node current = head; // Start from the head
        while (current != null) { // Traverse until the end
            System.out.print(current.data + " -> ");
            current = current.next;
            count++;
        }
        System.out.println("null ," + "length: " + count); // Indicate end of the list
    }
    public static int searchLL(Node head, int find){
        Node temp = head;
        while (temp != null) {
            if(temp.data == find){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
    public static Node deleteKthNode(Node head, int k) {
        if(k <= 0 || head == null){return head;}
        
        // Node secondLast  = head;
        // Node last = head;
        // while (last.next != null) {
        //     secondLast = last;
        //     last = last.next;
        // }
        // secondLast.next = null;
        
        if (k == 1) {
            return head.next;
        }    
        Node prev = null;
        Node current = head;
        int count = 1;
    
        while (current != null && count <= k) {
            prev = current;
            current = current.next;
            count++;
            if(count == k){
                prev.next = current.next;
            }
        }
        return head;
    }
    public static Node addKthNode(Node head, int k, int element) {
        if (k == 1) {
            Node newNode = new Node(element);
            newNode.next = head; // Insert at the head (k == 1)
            return newNode;
        }
        int count = 1;
        Node temp = head;
        while (temp != null && count < k - 1) { // Traverse to the (k-1)th node
            temp = temp.next;
            count++;
        }
        if (temp == null) { // Validate k is within range
            System.out.println("Invalid position. Node cannot be added.");
            return head;
        }
        Node newNode = new Node(element); // Insert the new node
        newNode.next = temp.next; // Link new node to the k-th node
        temp.next = newNode; // Link (k-1)th node to the new node
        return head;
    }
    public static Node addBeforeNthNode(Node head, int element, int n){
        // if(head == null){
        //     return null;
        // }
        // if(head.data == n){
        //     return new Node(element);
        // }
        // Node temp = head;
        // while (temp.next != null) {
        //     if(temp.next.data == n){
        //         Node x = new Node(element);
        //         temp.next = x;
        //         break;
        //     }
        //     temp = temp.next;
        // }
        // return head;
        if (n <= 1) { // Insert at the beginning
            Node newNode = new Node(element);
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        for (int i = 1; i < n - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range. Element not added.");
            return head;
        }

        Node newNode = new Node(element);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
    public static Node removeNthFromEnd(Node head, int n){
        Node dummy = new Node(0);
        dummy.next = head;

        Node slowPointer = dummy;
        Node fastPointer = dummy;

        while (fastPointer.next != null) {
            if(n <= 0){
                slowPointer = slowPointer.next;
            }
            fastPointer = fastPointer.next;
            n -= 1;
        }
        slowPointer.next = slowPointer.next.next;
        return dummy.next;
    }
    public static void main(String[] args){
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrayToLL(arr);
        printLinkedList(head);
        
        int find = 5;
        int result = searchLL(head, find);
        System.out.println(result);

        int k = 3;
        head = deleteKthNode(head, k);
        printLinkedList(head);

        int position = 2;
        int element = 10;
        addKthNode(head, position, element);
        printLinkedList(head);

        head = addBeforeNthNode(head, 10, 3);
        System.out.println("After adding 10 before the 3rd node:");
        printLinkedList(head);

        head = removeNthFromEnd(head, 2);
        System.out.println("After removing the 2nd node from the end:");
        printLinkedList(head);
    }
}