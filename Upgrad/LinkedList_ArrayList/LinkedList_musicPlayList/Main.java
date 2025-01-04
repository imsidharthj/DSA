import java.util.*;

class Node {
    String songTitle;
    Node next;

    public Node(String songTitle) {
        this.songTitle = songTitle;
        this.next = null;
    }
}

class Playlist {
    Node head;

    public Playlist() {
        this.head = null;
    }
    
    public void addSong(String songTitle) {
        Node newNode = new Node(songTitle);
        if(head == null){
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

public void displayPlaylist() {
        Node current = head;
        while (current != null) {
            System.out.println(current.songTitle);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist myPlaylist = new Playlist();
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfSongs; i++) {
            String song = scanner.nextLine();
            myPlaylist.addSong(song);
        }
        myPlaylist.displayPlaylist();
    }
}