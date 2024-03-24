import java.util.*;

public class MaxLengthChaninPairs {
     public static void main(String[] args) {
          int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

          // Sort the pairs array based on the ending values of the pairs
          Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

          int ans = 1; // Initialize the maximum length of chain pairs
          int pairEnd = pairs[0][1]; // Set the end of the last selected pair

          // Iterate through the sorted pairs array
          for (int i = 1; i < pairs.length; i++) {
               // Check if the starting value of the current pair is greater than the end of
               // the last selected pair
               if (pairs[i][0] > pairEnd) {
                    ans++; // Increment the count of chain pairs
                    pairEnd = pairs[i][1]; // Update the end of the last selected pair
               }
          }

          // Print the maximum length of chain pairs
          System.out.println("Maximum length of chain pairs: " + ans);
     }
}
