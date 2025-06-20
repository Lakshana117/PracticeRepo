import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added product: " + product);
    }

    public void updateProduct(String productId, String newName, int newQty, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(newName);
            product.setQuantity(newQty);
            product.setPrice(newPrice);
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Removed product: " + removed);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Inventory List ---");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
        System.out.println("----------------------\n");
    }
}
