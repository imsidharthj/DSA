import java.text.SimpleDateFormat;
import java.util.*;

public class FoodDeliverySystem {
    private static UserService userService = new UserService();
    private static RestaurantService restaurantService = new RestaurantService();
    private static OrderService orderService = new OrderService(userService);
    private static DeliveryService deliveryService = new DeliveryService();
    private static User currentUser;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Food Ordering System");
            System.out.println("1. Customer");
            System.out.println("2. Restaurant");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> customerMenu();
                case 2 -> restaurantMenu();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter card number: ");
        int cardNumber = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        User newUser = new User(username, password, name, cardNumber, pin);
        userService.registerUser(newUser);
        System.out.println("Registration successful.");
        currentUser = userService.getUser(username);
        showUserMenu();
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        boolean loginSuccess = userService.authenticateUser(username, password);
        if (loginSuccess) {
            System.out.println("Login successful.");
            currentUser = userService.getUser(username);
            showUserMenu();
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    private static void showUserMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Order Food");
            System.out.println("2. Your Orders");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showRestaurants();
                case 2 -> showOrderHistory();
                case 3 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        System.out.println("\nAvailable Restaurants:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }

        System.out.print("Enter restaurant number to view menu (or 0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) {
            return;
        }

        if (choice > 0 && choice <= restaurants.size()) {
            Restaurant selectedRestaurant = restaurants.get(choice - 1);
            showMenu(selectedRestaurant);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showMenu(Restaurant restaurant) {
        List<MenuItem> menu = restaurant.getMenu();
        int orderId = generateOrderId(restaurant);
        Date orderDate = new Date();
        Order order = new Order(orderId, restaurant.getName(), currentUser, orderDate);

        System.out.println("\nMenu for " + restaurant.getName() + ":");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - ₹" + item.getPrice());
        }

        while (true) {
            System.out.print("Enter item number to order (or 0 to finalize): ");
            int choice = scanner.nextInt();

            if (choice == 0)
                break;

            if (choice > 0 && choice <= menu.size()) {
                MenuItem selectedItem = menu.get(choice - 1);
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " added to your order.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        List<MenuItem> selectedItems = order.getItems();
        double total = order.getTotalCost();
        System.out.println("Selected items:");
        for (MenuItem item : selectedItems) {
            System.out.println("- " + item.getName() + ": ₹" + item.getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Total: ₹" + total);
        System.out.println("Do you want to place the order? (yes/no)");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("yes")) {
            placeOrder(order);
            System.out.println("Order placed successfully!");
            showDeliveryProcess(order);
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private static int generateOrderId(Restaurant restaurant) {
        int firstCharAscii = restaurant.getName().charAt(0);
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String timestamp = sdf.format(new Date());
        String orderIdStr = firstCharAscii + timestamp;

        return Integer.parseInt(orderIdStr);
    }

    private static void placeOrder(Order order) {
        // Scanner scanner = new Scanner(System.in);
        // int cardNumber = scanner.nextInt();
        // int pin = scanner.nextInt();
        // boolean paymentSuccessful = orderService.placeOrder(order, cardNumber, pin);
        // if(paymentSuccessful){
        //     currentUser.addOrderToHistory(order);
        // }
        System.out.print("Enter card number: ");
        int cardNumber = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        orderService.placeOrder(order, cardNumber, pin);
        currentUser.addOrder(order);
    }

    private static void showDeliveryProcess(Order order) {
        System.out.println("Delivery Process for Order: " + order.getOrderId());
        System.out.println("Order status shown below: ");
        deliveryService.addOrderToDeliveryQueue(order);
        deliveryService.processDeliveryQueue();
    }

    private static void showOrderHistory() {
        Stack<Order> orderHistory = currentUser.getOrderHistory();

        if (orderHistory.isEmpty()) {
            System.out.println("No orders found in the order history.");
        } else {
            System.out.println("Order History:");
            for (Order order : orderHistory) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Items ordered from " + order.getRestaurantName() + ":");
                for (MenuItem item : order.getItems()) {
                    System.out.println("- " + item.getName() + " (₹" + item.getPrice() + ")");
                }
                System.out.println("Order Date: " + order.getOrderDate());
                System.out.println("Total Cost: ₹" + order.getTotalCost());
                System.out.println("Delivered: " + (order.isDelivered() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }

    private static void restaurantMenu() {
        while (true) {
            System.out.println("\nRestaurant Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerRestaurant();
                case 2 -> loginRestaurant();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerRestaurant() {
        System.out.println("Enter Restaurant name: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = new Restaurant(restaurantName);
        restaurantService.addRestaurant(restaurant);
        System.out.println("Registration successful: " + restaurant.getName());
        manageRestaurantMenu(restaurant);
    }

    private static void loginRestaurant() {
        System.out.print("Enter restaurant name: ");
        String name = scanner.nextLine();
        Restaurant restaurant = restaurantService.getRestaurant(name);

        if (restaurant != null) {
            System.out.println("Login successful.");
            manageRestaurantMenu(restaurant);
        } else {
            System.out.println("Login failed. Restaurant not found.");
        }
    }

    private static void manageRestaurantMenu(Restaurant restaurant) {
        do {
            System.out.println("\nRestaurant Menu Management:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Back to previous menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the name of the new item: ");
                    String newItemName = scanner.nextLine();
                    System.out.print("Enter the price of the new item: ");
                    double newItemPrice = scanner.nextDouble();
                    restaurant.addNewMenuItem(newItemName, newItemPrice);
                }
                case 2 -> {
                    System.out.print("Enter the name of the item to remove: ");
                    String removeItemName = scanner.next();
                    MenuItem itemToRemove = null;
                    for (MenuItem menuItem : restaurant.getMenu()) {
                        if (menuItem.getName().equalsIgnoreCase(removeItemName)) {
                            itemToRemove = menuItem;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        restaurant.removeMenuItem(itemToRemove);
                        System.out.println("Item removed from the menu: " + removeItemName);
                    } else {
                        System.out.println("Item not found in the menu: " + removeItemName);
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (true);
    }
}