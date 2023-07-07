/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10318621;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Ethan
 */
public class ST10318621Test {
    
    public ST10318621Test() {
    }

    @Test
    public void testDeveloperArray() {
        String[] developers = { "Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer" };
        // Assuming the developers array is populated as expected in the program
        Assert.assertArrayEquals(developers, ST10318621.getDevelopers);
    }

    // Unit test for displaying the developer and duration for the task with the longest duration
    @Test
    public void testDisplayDeveloperAndDurationForLongestTask() {
        String[] developers = { "Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer" };
        int[] taskDurations = { 5, 8, 2, 11 };
        int longestDurationIndex = 3; // Assuming task 4 (index 3) has the longest duration

        String expected = developers[longestDurationIndex] + ", " + taskDurations[longestDurationIndex];
        Assert.assertEquals(expected, ST10318621.displayDeveloperAndDurationForLongestTask);
    }

    // Unit test for searching for a task by name and returning the developer and task name
    @Test
    public void testSearchTaskByName() {
        String taskName = "Create Login";
        String expected = "Mike Smith, Create Login";
        Assert.assertEquals(expected, ST10318621.searchTaskByName(taskName));
    }

    // Unit test for searching all tasks assigned to a specific developer and returning the task names
    @Test
    public void testSearchTasksByDeveloper() {
        String developer = "Samantha Paulson";
        String expected = "Create Reports";
        Assert.assertEquals(expected, ST10318621.searchTasksByDeveloper(developer));
    }

    // Unit test for deleting a task from the array and returning a success message
    @Test
    public void testDeleteTask() {
        String taskName = "Create Reports";
        String expected = "Entry \"" + taskName + "\" successfully deleted";
        Assert.assertEquals(expected, ST10318621.deleteTask(taskName));
    }

    // Unit test for displaying the task report
    @Test
    public void testDisplayTaskReport() {
        // Assuming the task report is returned as a string
        String expected = "Task Report:\n" +
                "Task Name: Create Login\n" +
                "Task ID: AD:0:SMS\n" +
                "Task Duration: 5\n" +
                "Task Status: To Do\n" +
                "----------------------------\n" +
                "Task Name: Create Add Features\n" +
                "Task ID: AD:1:EDH\n" +
                "Task Duration: 8\n" +
                "Task Status: Doing\n" +
                "----------------------------\n" +
                "Task Name: Create Reports\n" +
                "Task ID: AD:2:SPA\n" +
                "Task Duration: 2\n" +
                "Task Status: Done\n" +
                "----------------------------\n" +
                "Task Name: Add Arrays\n" +
                "Task ID: AD:3:GLO\n" +
                "Task Duration: 11\n" +
                "Task Status: To Do\n" +
                "----------------------------\n";
        Assert.assertEquals(expected, ST10318621.displayTaskReport);
    }
}