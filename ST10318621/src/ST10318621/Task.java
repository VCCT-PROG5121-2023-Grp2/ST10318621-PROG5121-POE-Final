/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10318621;
import javax.swing.JOptionPane;

/**
 *
 * @author Ethan
 */

public class Task {
   private String name;
    private int number;
    private String description;
    private String developer;
    private int duration;
    private String id; 
    private String status;
    private static int totalHours = 0;

    public Task(String name, String description, String developer, int duration) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        createTaskID();
        status = "To Do";
        totalHours += duration;
    }

    private void createTaskID() {
        String taskNamePrefix = name.substring(0, 2).toUpperCase();
        String taskNumber = String.valueOf(number);
        String developerSuffix = developer.substring(developer.length() - 3).toUpperCase();

        id = taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        createTaskID();
    }

    public String getDescription() {
        return description;
    }

    public void checkTaskDescription(String description) {
        if (description.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters.");
        } else {
            this.description = description;
            System.out.println("Task successfully captured.");
        }
    }

    public String getDeveloper() {
        return developer;
    }

    public int getDuration() {
        return duration;
    }

    public String getID() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printTaskDetails() {
    String message = "Task Status: " + status + "\n" +
                     "Developer Details: " + developer + "\n" +
                     "Task Number: " + number + "\n" +
                     "Task Name: " + name + "\n" +
                     "Task Description: " + description + "\n" +
                     "Task ID: " + id + "\n" +
                     "Duration: " + duration + " days";

    JOptionPane.showMessageDialog(null, message, "Task Details", JOptionPane.INFORMATION_MESSAGE);
}
    
    public static int returnTotalHours() {
        return totalHours;
    }
}


