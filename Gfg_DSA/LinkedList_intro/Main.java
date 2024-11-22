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
    public static Node deleteNode(Node head) {
        Node secondLast  = head;
        Node last = head;
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrayToLL(arr);
        printLinkedList(head);
        
        // int find = 5;
        // int result = searchLL(head, find);
        // System.out.println(result);

        head = deleteNode(head);
        printLinkedList(head);
    }
}