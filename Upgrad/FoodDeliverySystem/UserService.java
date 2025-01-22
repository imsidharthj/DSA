import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean processPayment(User user, double amount, int cardNumber, int pin) {
        if (users.contains(user)) {
            if (verifyPIN(user, cardNumber, pin)) {
                System.out.println("Processing payment of ₹" + amount + " for user: " + user.getUsername());
                return true;
            } else {
                System.out.println("PIN verification failed for user: " + user.getUsername());
                return false;
            }
        } else {
            System.out.println("User not found: " + user.getUsername());
            return false;
        }
    }

    private boolean verifyPIN(User user, int cardNumber, int pin) {
        if(cardNumber == user.getCardNumber() && pin == user.getPin()){
            return true;
        }
        return false;
        // return cardNumber == user.getCardNumber() && pin == user.getPin();
    }
}