package Code;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.0),
            new Order(102, "Bob", 150.5),
            new Order(103, "Charlie", 300.75),
            new Order(104, "David", 99.99)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Apply Bubble Sort
        bubbleSort(orders);
        System.out.println("\nSorted with Bubble Sort:");
        printOrders(orders);

        // Resetting the array
        orders = new Order[]{
            new Order(101, "Alice", 250.0),
            new Order(102, "Bob", 150.5),
            new Order(103, "Charlie", 300.75),
            new Order(104, "David", 99.99)
        };

        // Apply Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted with Quick Sort:");
        printOrders(orders);
    }

    // 🔹 Bubble Sort Method
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // 🔹 Quick Sort Method
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // 🔹 Utility Method to Print Orders
    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
