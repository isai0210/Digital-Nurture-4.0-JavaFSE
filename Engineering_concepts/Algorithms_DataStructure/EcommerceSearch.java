import java.util.Arrays;

class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class EcommerceSearch {

    // Linear Search
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (assumes array sorted by productName)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Phone", "Electronics"),
            new Product("P003", "Shoes", "Fashion"),
            new Product("P004", "Book", "Books")
        };

        System.out.println("Linear Search:");
        int idx1 = linearSearch(products, "Phone");
        System.out.println(idx1 >= 0 ? products[idx1] : "Product not found");

        // Sort products by productName for binary search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        System.out.println("\nBinary Search:");
        int idx2 = binarySearch(products, "Phone");
        System.out.println(idx2 >= 0 ? products[idx2] : "Product not found");
    }
}
