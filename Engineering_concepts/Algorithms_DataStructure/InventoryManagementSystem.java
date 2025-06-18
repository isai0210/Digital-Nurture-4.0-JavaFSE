import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + productId + '\'' +
                ", Name='" + productName + '\'' +
                ", Quantity=" + quantity +
                ", Price=" + price +
                '}';
    }
}

class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, String name, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void deleteProduct(String productId) {
        if (products.remove(productId) == null) {
            System.out.println("Product not found: " + productId);
        }
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        inventory.addProduct(new Product("P001", "Laptop", 10, 999.99));
        inventory.addProduct(new Product("P002", "Monitor", 20, 199.99));
        inventory.addProduct(new Product("P003", "Keyboard", 50, 49.99));

        System.out.println("Inventory after adding products:");
        inventory.displayInventory();

       
        inventory.updateProduct("P001", "Gaming Laptop", 8, 1099.99);

        
        inventory.deleteProduct("P002");

        System.out.println("\nInventory after update and delete:");
        inventory.displayInventory();

        inventory.deleteProduct("P004");
    }
}
