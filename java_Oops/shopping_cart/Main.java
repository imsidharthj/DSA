import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ShoppingCart {
    private HashMap<String, Double> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addItem(String title, Double price) {
        cart.put(title, price);
    }

    public void removeItem(String title) {
        if (cart.containsKey(title)) {
            cart.remove(title);
        } else{
            System.out.println("Item not found: " + title);
        }
    }

    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (double price : cart.values()) {
            totalPrice += price;
        }
        return totalPrice;
    }

    public void displayItems() {
        System.out.println("Items in the Shopping Cart:");
        for (HashMap.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: $" + entry.getValue());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Shirt", 25.99);
        cart.addItem("Jeans", 39.99);

        cart.displayItems();

        cart.removeItem("Shirt");

        cart.addItem("Shoes", 49.99);

        cart.displayItems();

        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total Price: $" + totalPrice);
    }
}
