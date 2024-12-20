import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String args[] ) throws Exception {
		int totalTickets = 50;

        TicketBooking ticketBooking = new TicketBooking(totalTickets);

        Thread thread1 = new Thread(() -> ticketBooking.bookTicket(5));
        Thread thread2 = new Thread(() -> ticketBooking.bookTicket(5));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Remaining tickets: " + ticketBooking.getAvailableTickets());
	}
}

class TicketBooking {
    private int availableTickets;

    public TicketBooking(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public synchronized void bookTicket(int numOfTickets) {
        if (numOfTickets <= availableTickets) {
            availableTickets -= numOfTickets;
            System.out.println("Tickets booked: " + numOfTickets);
        } else {
            System.out.println("Insufficient tickets available");
        }
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }
}