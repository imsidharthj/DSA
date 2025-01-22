import java.util.Stack;

public class User {
    private String username;
    private String password;
    private String name;
    private int cardNumber;
    private int pin;
    private Stack<Order> orderHistory;

    public User(String username, String password, String name, int cardNumber, int pin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.orderHistory = new Stack<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public int getPin() {
        return pin;
    }

    public void addOrder(Order order) {
        orderHistory.push(order);
    }

    public Stack<Order> getOrderHistory() {
        return orderHistory;
    }
}