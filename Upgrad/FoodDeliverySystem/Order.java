import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private String restaurantName;
    private List<MenuItem> items;
    private Date orderDate;
    private double totalCost;
    private boolean isDelivered;
    private DeliveryStatus deliveryStatus;

    public Order(int orderNumber, String restaurantName, User user, Date orderDate) {
        this.orderId = orderNumber;
        this.user = user;
        this.restaurantName = restaurantName;
        this.items = new ArrayList<>();
        this.orderDate = orderDate;
        this.totalCost = 0.0;
        this.isDelivered = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        totalCost = totalCost + item.getPrice();
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        totalCost -= item.getPrice();
    }
}