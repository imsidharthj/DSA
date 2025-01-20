/**
 * This Restaurant class represents a restaurant in the system and includes attributes such as name
 * and a list of menu items. It also includes methods for adding and removing menu items from the restaurant's menu.
 * Each MenuItem object represents an individual menu item, and the menu is stored as a list of MenuItem objects.
 * This allows for easy management and manipulation of the restaurant's menu.
 * Additional methods related to menu management has been added to this class.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class Restaurant {
     private String name;
     private List<MenuItem> menu;
 
     public Restaurant(String name) {
         this.name = name;
         this.menu = new ArrayList<>();
     }
 
     // Getter and setter for name
     public String getName() {
         return name;
     }
 
     public void addNewMenuItem(String itemName, double itemPrice) {
         MenuItem newitem = new MenuItem(itemName, itemPrice);
         menu.add(newitem);
         System.out.println("New item added to the menu: " + newitem);
     }
 
     // Method to remove a menu item from the menu
     public void removeMenuItem(MenuItem item) {
         menu.remove(item);
     }
 
     // Getter for menu
     public List<MenuItem> getMenu() {
         return menu;
     }
 }