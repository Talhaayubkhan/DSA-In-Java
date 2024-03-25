package PracticeQuestion;

import java.util.*;

public class MaximumBalancedStringPosition {

     // Method to calculate the maximum number of balanced string positions
     public static int BalancedPosition(String str, int n) {
          if (n == 0) {
               return 0; // If the string is empty, return 0
          }

          int R = 0, L = 0; // Counters for 'R' and 'L' characters
          int count = 0; // Counter for the maximum number of balanced string positions

          for (int i = 0; i < n; i++) {
               if (str.charAt(i) == 'R') {
                    R++; // Increment R count when encountering 'R'
               } else if (str.charAt(i) == 'L') {
                    L++; // Increment L count when encountering 'L'
               }

               if (L == R) {
                    count++; // If the number of 'L's equals the number of 'R's, increment the count
               }
          }

          return count; // Return the maximum number of balanced string positions
     }

     public static void main(String[] args) {
          String str = "LRRRRLLRLLRL"; // Example input string
          int n = str.length(); // Length of the input string
          System.out.println("Total maximum String Positions: " + BalancedPosition(str, n)); // Output the result
     }
}
