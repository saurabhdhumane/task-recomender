import java.time.LocalDate;
import java.util.Scanner;

public class TaskReminderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Task Reminder Application");
            System.out.println("1. Create a task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter priority (1: Low, 2: Medium, 3: High): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    Task newTask = new Task(name, dueDate, category, priority);
                    taskManager.addTask(newTask);
                    System.out.println("Task created successfully!");
                    break;

                case 2:
                    System.out.println("Viewing tasks:");
                    int taskCount = taskManager.getTaskCount();
                    if (taskCount == 0) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("All tasks:");
                        System.out.println("--------------------------------------------------");
                        for (int i = 0; i < taskCount; i++) {
                            Task task = taskManager.getTask(i);
                            System.out.println("Task ID: " + (i + 1));
                            System.out.println("Task Name: " + task.getName());
                            System.out.println("Due Date: " + task.getDueDate());
                            System.out.println("Category: " + task.getCategory());
                            System.out.println("Priority: " + task.getPriority());
                            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.markTaskAsCompleted(index);
                    System.out.println("Task marked as completed!");
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}