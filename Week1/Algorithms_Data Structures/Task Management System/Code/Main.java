package Code;

public class Main {
    
    // Task class
    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    // Node class for linked list
    static class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Singly Linked List implementation
    static class TaskLinkedList {
        private TaskNode head;

        // Add Task at the end
        public void addTask(Task task) {
            TaskNode newNode = new TaskNode(task);
            if (head == null) {
                head = newNode;
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Search Task by ID
        public Task searchTask(int taskId) {
            TaskNode current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        // Traverse and print all tasks
        public void traverseTasks() {
            if (head == null) {
                System.out.println("No tasks available.");
                return;
            }
            TaskNode current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        // Delete Task by ID
        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.task.taskId == taskId) {
                head = head.next;
                System.out.println("Task with ID " + taskId + " deleted.");
                return;
            }

            TaskNode current = head;
            while (current.next != null && current.next.task.taskId != taskId) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Task not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Task with ID " + taskId + " deleted.");
            }
        }
    }

    // Main method to test functionality
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Develop Backend", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Pending"));

        // Traverse
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search
        System.out.println("\nSearching for Task ID 2:");
        Task t = taskList.searchTask(2);
        System.out.println(t != null ? t : "Not found");

        // Delete
        System.out.println("\nDeleting Task ID 2:");
        taskList.deleteTask(2);

        // Traverse again
        System.out.println("\nTasks after deletion:");
        taskList.traverseTasks();
    }
}
