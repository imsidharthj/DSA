import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNewMenuItem(String itemName, double itemPrice) {
        MenuItem newitem = new MenuItem(itemName, itemPrice);
        menu.add(newitem);
        System.out.println("New item added to the menu: " + newitem.getName());
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}