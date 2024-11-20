class Book {
    private String title;
    private String author;
    private int yearPublished;

    // Parameterised constructor
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating an array of Book objects
        Book[] books = new Book[3];

        // Initializing the array with book details
        books[0] = new Book("Java: The Complete Reference", "Herbert Schildt", 2021);
        books[1] = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2008);
        books[2] = new Book("The Alchemist", "Paulo Coelho", 1988);

        // Displaying details of all books
        for (Book book : books) {
            book.displayDetails();
        }
    }
}