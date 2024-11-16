import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Main {

    private int size;
    Main(){
        this.size = 0;
    }

    class Node{ // Inner Node class
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Head of the linked list
    private Node head;

    // add - first, last
    public void addFirst(String data){ // Add a node at the beginning of the list
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data){ // Add a node at the end of the list
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lasNode = head.next;
        while (lasNode.next != null) {
            lasNode = lasNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    public int getSize(){
        return size;
    }
    public void printList(){ // Print the linked list
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curNode = head;
        while (curNode.next != null) {
            System.out.print(curNode.data + "->");
            curNode = curNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Main list = new Main();
        list.addFirst("a");
        list.addFirst("b");
        list.addLast("c");
        list.addLast("d");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());
    }
}