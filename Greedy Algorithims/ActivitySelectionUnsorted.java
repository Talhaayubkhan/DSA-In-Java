import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionUnsorted {
     public static void main(String[] args) {
          // Given unsorted arrays representing start and end times of activities
          int start[] = { 1, 3, 0, 5, 8, 5 };
          int end[] = { 2, 4, 6, 7, 9, 9 };

          // Create a 2D array to store index, start time, and end time of each activity
          int activities[][] = new int[start.length][3];

          // Populate the 2D array with indices, start times, and end times
          // Or
          // This loop iterates over each activity and fills in the corresponding row of
          // the activities array with the activity's index, start time, and end time.
          for (int i = 0; i < start.length; i++) {
               activities[i][0] = i; // Index of the activity
               activities[i][1] = start[i]; // Start time of the activity
               activities[i][2] = end[i]; // End time of the activity
          }

          // Sort activities based on end times using a custom comparator
          Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

          // Variables to store the maximum count and the indices of selected activities
          int count = 1;
          ArrayList<Integer> ans = new ArrayList<>();

          // Initialize with the first activity
          ans.add(activities[0][0]);
          int lastEnd = activities[0][2];

          // Iterate through the sorted array of activities
          for (int i = 1; i < end.length; i++) {
               // Check if the start time of the current activity is greater than or equal to
               // the end time of the last selected activity
               if (activities[i][1] >= lastEnd) {
                    // Increment the count of selected activities
                    count++;

                    // Add the index of the current activity to the list of selected activities
                    ans.add(activities[i][0]);

                    // Update the lastEnd with the end time of the current activity
                    lastEnd = activities[i][2];
               }
          }

          // Print the maximum count of non-overlapping activities
          System.out.println("max count is = " + count);

          // Print the indices of selected activities
          for (int i = 0; i < ans.size(); i++) {
               System.out.print("A" + ans.get(i) + " ");
          }
          System.out.println();
     }
}
