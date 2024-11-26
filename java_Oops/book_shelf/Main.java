import java.util.ArrayList;
import java.util.List;

class Bookshelf {
    // List to hold books as strings
    private List<String> books;

    public Bookshelf() {
        books = new ArrayList<>();
    }

    // Method to add a book to the bookshelf
    public void addBook(String title, String author, String genre) {
        String book = "Title: " + title + ", Author: " + author + ", Genre: " + genre;
        books.add(book);
        // System.out.println("Book added: " + title);
    }

    // Method to remove a book by title
    public void removeBook(String title) {
        for (String book : books) {
            if (book.startsWith("Title: " + title + ",")) {
                books.remove(book);
                // System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    // Method to display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books on the bookshelf.");
        } else {
            System.out.println("Books on the Bookshelf:");
            for (String book : books) {
                System.out.println(book);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();

        // Adding books
        bookshelf.addBook("To Kill a Mockingbird", "Harper Lee", "Classic");
        bookshelf.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");

        // Display books
        bookshelf.displayBooks();

        // Removing a book
        bookshelf.removeBook("The Great Gatsby");

        // Adding another book
        bookshelf.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy");

        // Display books again
        bookshelf.displayBooks();
    }
}
