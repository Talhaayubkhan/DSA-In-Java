import java.util.*;

public class ActivitySelection {
     public static void main(String[] args) {
          // Given arrays representing start and end times of activities
          int start[] = { 1, 3, 0, 5, 8, 5 };
          int end[] = { 2, 4, 6, 7, 9, 9 };

          // Sort activities based on end times
          Arrays.sort(end);

          // Variables to store the maximum count and the indices of selected activities
          int count = 1;
          ArrayList<Integer> ans = new ArrayList<>();

          // Initialize with the first activity
          ans.add(0);
          int lastEnd = end[0];

          // Iterate through the sorted array of end times
          for (int i = 1; i < end.length; i++) {
               // Check if the start time of the current activity is greater than or equal to
               // the end time of the last selected activity
               if (start[i] >= lastEnd) {
                    // Increment the count of selected activities
                    count++;

                    // Add the index of the current activity to the list of selected activities
                    ans.add(i);

                    // Update the lastEnd with the end time of the current activity
                    lastEnd = end[i];
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
