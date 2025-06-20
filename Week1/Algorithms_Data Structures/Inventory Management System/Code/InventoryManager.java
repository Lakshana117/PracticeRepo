import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update Product
    public void updateProduct(int id, String name, int quantity, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            inventory.remove(id);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display All
    public void displayAll() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
