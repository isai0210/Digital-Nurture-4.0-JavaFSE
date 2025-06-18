import java.util.Arrays;

class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "[" + bookId + ", " + title + ", " + author + "]";
    }
}

public class LibrarySearch {

    public static int linearSearch(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(targetTitle)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Java Programming", "John Doe"),
            new Book("B002", "Data Structures", "Jane Smith"),
            new Book("B003", "Algorithms", "Alice Johnson")
        };

        System.out.println("Linear Search:");
        int idx1 = linearSearch(books, "Algorithms");
        System.out.println(idx1 >= 0 ? books[idx1] : "Book not found");

        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("\nBinary Search:");
        int idx2 = binarySearch(books, "Algorithms");
        System.out.println(idx2 >= 0 ? books[idx2] : "Book not found");
    }
}
