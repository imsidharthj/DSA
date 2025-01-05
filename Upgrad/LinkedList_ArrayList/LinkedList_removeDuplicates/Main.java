import java.util.*;

class Node {
    String artifactName;
    Node prev;
    Node next;

    public Node(String artifactName) {
        this.artifactName = artifactName;
        this.prev = null;
        this.next = null;
    }
}

class LibraryCollection {
    Node head, tail;

    public LibraryCollection() {
        this.head = null;
        this.tail = null;
    }

    public void addArtifact(String artifactName) {
        Node newNode = new Node(artifactName);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void displayArtifacts() {
        Node current = head;
        while (current != null) {
            System.out.print(current.artifactName + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removeDuplicateArtifacts() {
        Node current = head;
        while(current != null && current.next != null){
            if (current.artifactName.equals(current.next.artifactName)) {
                Node duplicate = current.next;
                current.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = current;
                }
            } else {
                current = current.next;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LibraryCollection library = new LibraryCollection();
        for (int i = 0; i < n; i++) {
            library.addArtifact(scanner.next());
        }
        
        library.removeDuplicateArtifacts();
        library.displayArtifacts();
    }
}