public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shampoo", "Personal Care"),
            new Product(3, "T-shirt", "Clothing"),
            new Product(4, "Camera", "Electronics"),
            new Product(5, "Notebook", "Stationery")
        };

        // Perform Linear Search
        Product result1 = SearchUtility.linearSearch(products, "T-shirt");
        System.out.println("Linear Search Result:");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort products for Binary Search
        SearchUtility.sortProducts(products);

        // Perform Binary Search
        Product result2 = SearchUtility.binarySearch(products, "Camera");
        System.out.println("\nBinary Search Result:");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
