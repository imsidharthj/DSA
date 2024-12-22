import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Main {
    static class UsernameTracker {
        private Set<String> usernames;

        public UsernameTracker() {
            this.usernames = new HashSet<>();
        }

        public boolean addUsername(String username) {
            return usernames.add(username);
        }

        public boolean removeUsername(String username) {
            return usernames.remove(username);
        }

        public Set<String> getUsernames() {
            return usernames;
        }
    }
    
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);
        UsernameTracker usernameTracker = new UsernameTracker();
        System.out.print("Enter the number of usernames to add: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the usernames:");
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernameTracker.addUsername(username);
        }
        System.out.println("Usernames: " + usernameTracker.getUsernames());
        System.out.print("Enter the username to remove: ");
        String usernameToRemove = scanner.nextLine();
        boolean removed = usernameTracker.removeUsername(usernameToRemove);
        if (removed) {
            System.out.println("Usernames: " + usernameTracker.getUsernames());
        } else {
            System.out.println("Username not found.");
        }
        scanner.close();
	}
}