import java.util.*;
class TaskList {
    Node head, tail;

    public TaskList() {
        head = null;
        tail = null;
    }

    class Node {
        String description;
        boolean completed;
        Node next;

        Node(String description, boolean completed) {
            this.description = description;
            this.completed = completed;
            this.next = null;
        }
    }

    void insert(String description, boolean completed) {
        Node newNode = new Node(description, completed);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void deleteFirstCompletedTask() {
        if(head == null){
            return;
        }
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.completed) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.description);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TaskList taskList = new TaskList();

        for (int i = 0; i < n; i++) {
            String description = s.next();
            boolean completed = s.nextBoolean();
            taskList.insert(description, completed);
        }

        taskList.deleteFirstCompletedTask();
        taskList.printList();
    }
}