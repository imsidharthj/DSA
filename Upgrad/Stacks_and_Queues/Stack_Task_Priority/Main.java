import java.util.*;

class Task {
    char name;
    int priority;

    public Task(char name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

class TaskScheduler {
    private Stack<Task> taskStack;

    public TaskScheduler() {
        this.taskStack = new Stack<>();
    }

    public void scheduleTask(char name, int priority) {
        Task newTask = new Task(name, priority);
        Stack<Task> tempStack = new Stack<>();

        // Move tasks from taskStack to tempStack until the correct position is found
        while (!taskStack.isEmpty() && taskStack.peek().priority > newTask.priority) {
            tempStack.push(taskStack.pop());
        }
        taskStack.push(newTask);
        while (!tempStack.isEmpty()) {
            taskStack.push(tempStack.pop());
        }
    }

    public void executeTasks() {
        while (!taskStack.isEmpty()) {
            Task task = taskStack.pop();
            System.out.println("Executing task: " + task.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        int numberOfTasks = scanner.nextInt();

        for(int i=0 ; i<numberOfTasks ; i++) {
            char taskName = scanner.next().charAt(0);
            int priority = scanner.nextInt();
            scheduler.scheduleTask(taskName, priority);
        }
        
        scheduler.executeTasks();
    }
}