public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add Products
        manager.addProduct(new Product(101, "Mouse", 25, 450.0));
        manager.addProduct(new Product(102, "Keyboard", 15, 750.0));

        // Update
        manager.updateProduct(101, "Wireless Mouse", 30, 500.0);

        // Delete
        manager.deleteProduct(102);

        // Display All
        manager.displayAll();
    }
}
