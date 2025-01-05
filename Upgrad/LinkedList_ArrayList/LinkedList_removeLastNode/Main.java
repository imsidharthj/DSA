import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    static class Node {
        Product product;
        Node next;

        public Node(Product product) {
            this.product = product;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public ShoppingCart() {
        head = null;
        tail = null;
    }
    
    public void addProduct(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void deleteLastItem() {
        if (head == null) {
            System.out.println("Shopping cart is empty.");
            return;
        }
    
        if (head.next == null) {
            head = null;
            return;
        }
    
        Node slow = head;
        Node fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = null;
    }

    public void displayCart() {
        Node current = head;
        while (current != null) {
            System.out.println(current.product.name + ": $" + current.product.price);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        int numProducts = scanner.nextInt();

        for (int i = 0; i < numProducts; i++) {
            String name = scanner.next();
            double price = scanner.nextDouble();
            cart.addProduct(new Product(name, price));
        }

        cart.deleteLastItem();

        cart.displayCart();
    }
}