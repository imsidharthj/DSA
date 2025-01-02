import java.util.Scanner;

class Main{
    static Node head;

    static class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){
        Node head = null;
        Node tail = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int temp = scanner.nextInt();
            Node newNode = new Node(temp);

            if(head == null){
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        Node length = findMiddleNode(head);
        System.out.println(length.data);
    }

    public static Node findMiddleNode(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        double halfLength = Math.ceil(count / 2);
        int countList = 0;
        Node current = head;
        Node middleNode = null;
        while(current.next != null){
            if(countList == halfLength){
                middleNode = current;
            }
            current = current.next;
            countList++;
        }
        return middleNode;
    }
}