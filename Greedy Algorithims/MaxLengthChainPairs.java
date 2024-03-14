import java.util.*;

public class MaxLengthChainPairs {
     public static void main(String[] args) {
          // Define the pairs of integers
          int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

          // Sort the pairs array based on the second element of each pair
          Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

          // Initialize the variable to store the maximum length of the chain pairs
          int ans = 1;

          // Initialize the variable to store the end point of the last selected pair
          int pairEnd = pairs[0][1];

          // Loop through the pairs array starting from the second pair
          for (int i = 1; i < pairs.length; i++) {
               // Check if the first element of the current pair is greater than the end point
               // of the last selected pair
               if (pairs[i][0] > pairEnd) {
                    // If it is, increment the answer (maximum chain length) by 1
                    ans++;
                    // Update the end point of the last selected pair to the second element of the
                    // current pair
                    pairEnd = pairs[i][1];
               }
          }

          System.out.println("max chain length " + ans);
     }
}