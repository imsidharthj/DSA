import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {
    static class TaskManager {
        private List<String> tasks;

        public TaskManager() {
            this.tasks = new ArrayList<>();
        }

        public void addTask(String task) {
            tasks.add(task);
        }

        public boolean removeTask(String task) {
            return tasks.remove(task);
        }

        public List<String> getTasks() {
            return tasks;
        }
    }
    
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        System.out.print("Enter the number of tasks to add: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the tasks:");
        for (int i = 0; i < n; i++) {
            String task = scanner.nextLine();
            taskManager.addTask(task);
        }
        System.out.println("Tasks: " + taskManager.getTasks());
        System.out.print("Enter the task to remove: ");
        String taskToRemove = scanner.nextLine();
        boolean removed = taskManager.removeTask(taskToRemove);
        if (removed) {
            System.out.println("Tasks: " + taskManager.getTasks());
        } else {
            System.out.println("Task not found.");
        }
        scanner.close();
	}
}