package Code;

public class Main {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Developer", 75000));
        addEmployee(new Employee(2, "Bob", "Manager", 90000));
        addEmployee(new Employee(3, "Charlie", "Tester", 60000));

        System.out.println("All Employees:");
        traverseEmployees();

        System.out.println("\nSearching for Employee ID 2:");
        Employee e = searchEmployee(2);
        System.out.println(e != null ? e : "Not found");

        System.out.println("\nDeleting Employee ID 2");
        deleteEmployee(2);
        
        System.out.println("\nEmployees after deletion:");
        traverseEmployees();
    }

    // 🔹 Add employee
    public static void addEmployee(Employee emp) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = emp;
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    // 🔹 Search employee by ID
    public static Employee searchEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                return employees[i];
            }
        }
        return null;
    }

    // 🔹 Traverse and display all employees
    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    // 🔹 Delete employee by ID
    public static void deleteEmployee(int empId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        // Shift left
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;  // Clean up reference
        System.out.println("Employee with ID " + empId + " deleted.");
    }
}
