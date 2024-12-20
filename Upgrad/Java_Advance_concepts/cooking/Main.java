import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int numberOfCooks = scanner.nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCooks);

        for (int i = 1; i <= numberOfCooks; i++) {
            Cook cook = new Cook(i);
            executorService.execute(() -> {
                cook.marinate();
                cook.cook();
                cook.serve();
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait for all threads to finish
        }

        System.out.println("All cooks have finished their tasks.");
    }
}

class Cook {
    private final int id;

    public Cook(int id) {
        this.id = id;
    }

    public void marinate() {
        try {
            Thread.sleep(2000); // Simulate marinating for 2 seconds
            System.out.println("Cook finished marinating.");
        } catch (InterruptedException e) {
            System.out.println("Cook " + id + " was interrupted during marinating.");
        }
    }

    public void cook() {
        try {
            Thread.sleep(4000); // Simulate cooking for 4 seconds
            System.out.println("Cook finished cooking.");
        } catch (InterruptedException e) {
            System.out.println("Cook " + id + " was interrupted during cooking.");
        }
    }

    public void serve() {
        try {
            Thread.sleep(1000); // Simulate serving for 1 second
            System.out.println("Cook finished serving.");
        } catch (InterruptedException e) {
            System.out.println("Cook " + id + " was interrupted during serving.");
        }
    }
}
