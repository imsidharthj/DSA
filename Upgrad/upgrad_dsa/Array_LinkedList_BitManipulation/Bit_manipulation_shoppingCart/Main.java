// ArrayList for Cart Items:
// We use an ArrayList<Item> to store the items in the cart.
// Each item has a flags field that uses bit manipulation to track whether the item is on sale.
// LinkedList for Browsing History:
// We use a LinkedList<String> to store the browsing history. The LinkedList preserves the order
//  in which the user visits the pages, and it allows efficient removal and addition of elements.
// Bit Manipulation:
// Sale Status: Each item has a flags field that represents the sale status using bit flags. 
// We use the bitwise AND (&) and OR (|) operators to check and set the sale status.
// Count Items in Cart: We use bitwise operations to count the number of items in the cart. 
// Each item in the cart sets a bit in an integer (cartFlag), and then we count the number of 
// set bits to determine the number of items.

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    // Define an Item class to represent cart items
    static class Item {
        int itemId;      // Item ID
        int price;       // Item price
        int flags;       // Bit flags to represent item status (sale status, etc.)
        
        // Constructor
        public Item(int itemId, int price, int flags) {
            this.itemId = itemId;
            this.price = price;
            this.flags = flags;
        }

        // Check if the item is on sale (bit flag at position 0)
        public boolean isOnSale() {
            return (flags & 0x1) != 0;  // Check if the first bit is set
        }


        // Set the sale flag (bit flag at position 0)
        public void setSaleFlag(boolean onSale) {
            if (onSale) {
                flags |= 0x1;  // Set the first bit to 1 (on sale)
            } else {
                flags &= ~0x1; // Set the first bit to 0 (not on sale)
            }
        }

        // Method to return item details
        @Override
        public String toString() {
            return "Item ID: " + itemId + ", Price: " + price + ", On Sale: " + isOnSale();
        }

        // Helper method to count the number of set bits in the integer (cartFlag)
        public static int countItems(int cartFlag) {
            return Integer.bitCount(cartFlag);  // Count the number of 1s in the binary representation
        }
    }

    public static void main(String[] args) {
        // Step 1: Using ArrayList for Cart Items
        ArrayList<Item> cart = new ArrayList<>();
        cart.add(new Item(101, 20, 0x1));  // Item 1 (on sale)
        cart.add(new Item(102, 30, 0x0));  // Item 2 (not on sale)
        cart.add(new Item(103, 50, 0x1));  // Item 3 (on sale)
        
        // Step 2: Using LinkedList for Browsing History
        LinkedList<String> browsingHistory = new LinkedList<>();
        browsingHistory.add("Home Page");
        browsingHistory.add("Electronics Category");
        browsingHistory.add("Smartphone Product Page");
        
        // Step 3: Bit Manipulation to check sale status of items in the cart
        System.out.println("Shopping Cart Items:");
        for (Item item : cart) {
            System.out.println(item);
        }

        // Adding a new item to the cart
        Item newItem = new Item(104, 60, 0x0); // Item 4 (not on sale)
        cart.add(newItem);

        // Marking Item 104 as on sale using bit manipulation
        newItem.setSaleFlag(true);

        System.out.println("\nAfter updating Item 104 Sale Status:");
        for (Item item : cart) {
            System.out.println(item);
        }

        // Step 4: Browsing History
        System.out.println("\nBrowsing History:");
        for (String page : browsingHistory) {
            System.out.println(page);
        }

        // Simulate the user removing the last page from browsing history (as if they went back)
        browsingHistory.removeLast();

        System.out.println("\nAfter Removing Last Browsing Page:");
        for (String page : browsingHistory) {
            System.out.println(page);
        }

        // Step 5: Count the number of items in the cart using bit manipulation (set bits)
        int cartFlag = 0;
        for (int i = 0; i < cart.size(); i++) {
            cartFlag |= (1 << i);  // Set a bit for each item in the cart
        }
        int itemCount = Item.countItems(cartFlag);  // Count the number of items in the cart using bit count
        System.out.println("\nTotal items in the cart: " + itemCount);

    }
}