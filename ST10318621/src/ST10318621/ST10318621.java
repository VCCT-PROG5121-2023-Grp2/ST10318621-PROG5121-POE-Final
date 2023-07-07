
package ST10318621;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * GitHub link to my repository- 
 * @author Ethan Donaldson ST10318621
 */

public class ST10318621 {
    private static Login login;
    static Object[] getDevelopers;
    static Object displayDeveloperAndDurationForLongestTask;
    static Object displayTaskReport;
    

    public static void main(String[] args) {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        OUTER:
        while (true) {
            System.out.println("Welcome to the Login System. Enter your choice:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Registering a user
                    System.out.println("Enter your first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter your last name:");
                    String lastName = scanner.next();
                    System.out.println("Enter your username:");
                    String username = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    login.registerUser(firstName, lastName, username, password);
                    break;
                case 2:
                    // Logging in a user
                    System.out.println("Enter your username:");
                    username = scanner.next();
                    System.out.println("Enter your password:");
                    password = scanner.next();
                    if (login.loginUser(username, password)) {
                        System.out.println("Welcome to EasyKanban!");

                        // Task management
                        System.out.println("How many tasks do you want to enter?");
                        int numTasks = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        // Arrays for storing task details
                        String[] developers = new String[numTasks];
                        String[] taskNames = new String[numTasks];
                        String[] taskIDs = new String[numTasks];
                        int[] taskDurations = new int[numTasks];
                        String[] taskStatuses = new String[numTasks];

                        for (int i = 0; i < numTasks; i++) {
                            System.out.println("Enter task name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter task description:");
                            String description = scanner.nextLine();
                            System.out.println("Enter developer details:");
                            String developer = scanner.nextLine();
                            System.out.println("Enter task duration:");
                            int duration = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                            Task task = new Task(name, description, developer, duration);
                            login.addTask(task);
                            System.out.println("Task added successfully!");

                            // Task status selection
                            System.out.println("Select task status:");
                            System.out.println("1. To Do");
                            System.out.println("2. Done");
                            System.out.println("3. Doing");
                            int statusChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            String status;
                            switch (statusChoice) {
                                case 1:
                                    status = "To Do";
                                    break;
                                case 2:
                                    status = "Done";
                                    break;
                                case 3:
                                    status = "Doing";
                                    break;
                                default:
                                    System.out.println("Invalid status choice. Setting status to default: To Do");
                                    status = "To Do";
                                    break;
                            }
                            task.setStatus(status);

                            // Populate arrays
                            developers[i] = developer;
                            taskNames[i] = name;
                            taskIDs[i] = task.getID();
                            taskDurations[i] = duration;
                            taskStatuses[i] = status;
                        }

                        System.out.println("Task entry completed.");

                        // Print array contents
                        System.out.println("Developer Names:");
                        for (String developer : developers) {
                            System.out.println(developer);
                        }

                        System.out.println("Task Names:");
                        for (String taskName : taskNames) {
                            System.out.println(taskName);
                        }

                        System.out.println("Task Durations:");
                        for (int taskDuration : taskDurations) {
                            System.out.println(taskDuration);
                        }

                        // Additional functionalities

                        // a. Display Developer, Task Names, and Task Duration for tasks with the status of Done
                        System.out.println("Tasks with status Done:");
                        for (int i = 0; i < numTasks; i++) {
                            if (taskStatuses[i].equals("Done")) {
                                System.out.println("Developer: " + developers[i] +
                                        ", Task Name: " + taskNames[i] +
                                        ", Task Duration: " + taskDurations[i]);
                            }
                        }

                        // b. Display Developer and Duration of the task with the longest duration
                        int maxDurationIndex = 0;
                        for (int i = 1; i < numTasks; i++) {
                            if (taskDurations[i] > taskDurations[maxDurationIndex]) {
                                maxDurationIndex = i;
                            }
                        }
                        System.out.println("Task with longest duration:");
                        System.out.println("Developer: " + developers[maxDurationIndex] +
                                ", Task Duration: " + taskDurations[maxDurationIndex]);

                        
                        // c. Search for a task with Task Name and display Task Name, Developer, and Task Status
                        System.out.println("Enter task name to search:");
                        String searchTaskName = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < numTasks; i++) {
                            if (taskNames[i].equalsIgnoreCase(searchTaskName)) {
                                System.out.println("Task Name: " + taskNames[i] +
                                        ", Developer: " + developers[i] +
                                        ", Task Status: " + taskStatuses[i]);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Task not found.");
                        }

                        // d. Search for all tasks assigned to a developer and display Task Name and Task Status
                        System.out.println("Enter developer name to search:");
                        String searchDeveloper = scanner.nextLine();
                        boolean developerFound = false;
                        for (int i = 0; i < numTasks; i++) {
                            if (developers[i].equalsIgnoreCase(searchDeveloper)) {
                                System.out.println("Task Name: " + taskNames[i] +
                                        ", Task Status: " + taskStatuses[i]);
                                developerFound = true;
                            }
                        }
                        if (!developerFound) {
                            System.out.println("No tasks assigned to the specified developer.");
                        }

                        // e. Delete a task using Task Name
                        System.out.println("Enter task name to delete:");
                        String deleteTaskName = scanner.nextLine();
                        boolean taskDeleted = false;
                        for (int i = 0; i < numTasks; i++) {
                            if (taskNames[i].equalsIgnoreCase(deleteTaskName)) {
                                taskNames[i] = null;
                                taskIDs[i] = null;
                                taskDurations[i] = 0;
                                taskStatuses[i] = null;
                                taskDeleted = true;
                            }
                        }
                        if (taskDeleted) {
                            System.out.println("Task deleted successfully.");
                        } else {
                            System.out.println("Task not found.");
                        }

                        // f. Display a report that lists the full details of all captured tasks
                        System.out.println("Task Report:");
                        for (int i = 0; i < numTasks; i++) {
                            System.out.println("Task Name: " + taskNames[i]);
                            System.out.println("Task ID: " + taskIDs[i]);
                            System.out.println("Task Duration: " + taskDurations[i]);
                            System.out.println("Task Status: " + taskStatuses[i]);
                            System.out.println("----------------------------");
                        }
                    } else {
                        System.out.println("Login failed. Please check your username and password.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break OUTER;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
                    
                    
            }
        }
       
    }
}
