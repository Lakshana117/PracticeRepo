import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Book class
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title (list must be sorted)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Utility to print all books
    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        System.out.println("📚 All Books:");
        printBooks(books);

        // 🔍 Linear Search
        System.out.println("\n🔍 Linear Search for '1984':");
        Book found1 = linearSearch(books, "1984");
        System.out.println(found1 != null ? found1 : "Book not found.");

        // 📏 Sort for Binary Search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        // 🔍 Binary Search
        System.out.println("\n🔍 Binary Search for 'The Alchemist':");
        Book found2 = binarySearch(books, "The Alchemist");
        System.out.println(found2 != null ? found2 : "Book not found.");
    }
}
