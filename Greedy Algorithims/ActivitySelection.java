import java.util.*;

public class ActivitySelection {
     public static void main(String[] args) {
          // Given arrays representing start and end times of activities
          int start[] = { 1, 3, 0, 5, 8, 5 };
          int end[] = { 2, 4, 6, 7, 9, 9 };

          // Initialize variables to track maximum activities and their indices
          int maxAct = 0; // Maximum number of activities
          ArrayList<Integer> ans = new ArrayList<>(); // List to store indices of selected activities

          // Select the first activity arbitrarily
          maxAct = 1; // At least one activity is selected initially
          ans.add(0); // Index 0 represents the first activity

          // Initialize the end time of the last selected activity
          int lastEnd = end[0]; // End time of the first activity

          // Iterate through the activities starting from the second one
          for (int i = 1; i < end.length; i++) {
               // If the start time of the current activity is greater than the end time of the
               // last selected activity,
               // it can be selected without overlapping
               if (start[i] >= lastEnd) {
                    maxAct++; // Increment the count of selected activities
                    ans.add(i); // Add the index of the current activity to the list of selected activities
                    lastEnd = end[i]; // Update the end time of the last selected activity
               }
          }

          // Print the maximum number of activities that can be selected
          System.out.println("Max Activities = " + maxAct);

          // Print the indices of selected activities
          for (int i = 0; i < ans.size(); i++) {
               System.out.print("A" + ans.get(i) + " ");
          }

          // Print a new line for formatting
          System.out.println();

     }
}
