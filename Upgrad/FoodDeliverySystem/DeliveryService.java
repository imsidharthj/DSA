import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DeliveryService {
    private Queue<Order> deliveryQueue;
    private Random random;

    public DeliveryService() {
        deliveryQueue = new LinkedList<>();
        random = new Random();
    }

    public void addOrderToDeliveryQueue(Order order) {
        order.setDeliveryStatus(DeliveryStatus.PREPARING);
        System.out.println(order.getDeliveryStatus());
        deliveryQueue.offer(order);
    }

    public void processDeliveryQueue() {
        while (!deliveryQueue.isEmpty()) {
            Order order = deliveryQueue.poll();
            prepareOrder(order);
            deliverOrder(order);
            order.setDelivered(true);
        }
    }

    private void prepareOrder(Order order) {
        simulateProcessingTime(60_000);
        order.setDeliveryStatus(DeliveryStatus.PREPARED);
        System.out.println(order.getDeliveryStatus());
    }

    private void deliverOrder(Order order) {
        order.setDeliveryStatus(DeliveryStatus.WAITING_FOR_DELIVERY);
        System.out.println(order.getDeliveryStatus());
        simulateProcessingTime(75_000);
        order.setDeliveryStatus(DeliveryStatus.OUT_FOR_DELIVERY);
        System.out.println(order.getDeliveryStatus());
        simulateProcessingTime(random.nextInt(31_000) + 30_000);
        order.setDeliveryStatus(DeliveryStatus.DELIVERED);
        System.out.println(order.getDeliveryStatus());
    }

    private void simulateProcessingTime(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}