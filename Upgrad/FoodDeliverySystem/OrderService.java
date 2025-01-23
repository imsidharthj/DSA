import java.util.LinkedList;
import java.util.Queue;

public class OrderService {
    private Queue<Order> ordersQueue;
    private UserService userService;

    public OrderService(UserService userService) {
        this.ordersQueue = new LinkedList<>();
        this.userService = userService;
    }

    public void placeOrder(Order order, int cardNumber, int pin) {
        if (userService.processPayment(order.getUser(), order.getTotalCost(), cardNumber, pin)) {
            ordersQueue.offer(order);
        } else {
            System.out.println("Order placement failed. Payment unsuccessful.");
        }
    }

    public Order getNextOrder() {
        return ordersQueue.poll();
    }

    public Order peekNextOrder() {
        return ordersQueue.peek();
    }
}
