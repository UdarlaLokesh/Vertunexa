import java.util.*;

class Book {
    private String title;
    private boolean isBorrowed;

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }
}

public class LibraryManagement {
    private static List<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleBooks(); // Add some books for testing

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewAvailableBooks();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> addBook();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addSampleBooks() {
        books.add(new Book("The Catcher in the Rye"));
        books.add(new Book("To Kill a Mockingbird"));
        books.add(new Book("1984"));
    }

    private static void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    private static void borrowBook() {
        System.out.print("\nEnter the book title to borrow: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("You borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available or already borrowed!");
    }

    private static void returnBook() {
        System.out.print("\nEnter the book title to return: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("You returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Invalid return! Book was not borrowed.");
    }

    private static void addBook() {
        System.out.print("\nEnter new book title: ");
        String title = scanner.nextLine();
        books.add(new Book(title));
        System.out.println("Book added successfully!");
    }
}
