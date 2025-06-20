public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Inventory Management System!\n");

        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P001", "Laptop", 50, 1200.00));
        manager.addProduct(new Product("P002", "Smartphone", 200, 800.00));
        manager.addProduct(new Product("P003", "Tablet", 150, 400.00));

        manager.displayInventory();

        System.out.println("Updating Smartphone details...");
        manager.updateProduct("P002", "Smartphone", 180, 750.00);

        System.out.println("Removing Tablet from inventory...");
        manager.deleteProduct("P003");

        manager.displayInventory();

        System.out.println("Thank you for using the Inventory Management System!");
    }
}
