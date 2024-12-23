import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // LoggingSystem class to manage logs
    static class LoggingSystem {
        private Map<String, List<String>> userActivities; // Map for user activities
        private List<String> systemEvents; // List for system events

        // Constructor
        public LoggingSystem() {
            this.userActivities = new HashMap<>();
            this.systemEvents = new ArrayList<>();
        }

        // Method to log user activity
        public void logUserActivity(String userId, String activity) {
            userActivities.putIfAbsent(userId, new ArrayList<>());
            userActivities.get(userId).add(activity);
        }

        // Method to log system event
        public void logSystemEvent(String eventDescription) {
            systemEvents.add(eventDescription);
        }

        // Method to get activities for a specific user
        public List<String> getUserActivities(String userId) {
            return userActivities.getOrDefault(userId, new ArrayList<>());
        }

        // Method to get all system events
        public List<String> getSystemEvents() {
            return systemEvents;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of LoggingSystem
        LoggingSystem loggingSystem = new LoggingSystem();

        // Log predefined user activities
        loggingSystem.logUserActivity("user123", "Viewed product X");
        loggingSystem.logUserActivity("user456", "Added product Y to cart");
        loggingSystem.logUserActivity("user123", "Purchased product X");
        loggingSystem.logUserActivity("user456", "Purchased product Y");

        // Log predefined system events
        loggingSystem.logSystemEvent("Server maintenance scheduled");
        loggingSystem.logSystemEvent("New version released");

        // Get user ID input to retrieve activities
        System.out.print("Enter user ID to get activities: ");
        String userId = scanner.nextLine();

        // Retrieve and display user activities
        List<String> userActivities = loggingSystem.getUserActivities(userId);
        System.out.println("Activities for " + userId + ": " + userActivities);

        // Retrieve and display system events
        List<String> systemEvents = loggingSystem.getSystemEvents();
        System.out.println("System Events: " + systemEvents);

        scanner.close();
    }
}
