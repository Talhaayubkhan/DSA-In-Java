import java.util.*;

public class MinAbsolutePairs {
     public static void main(String[] args) {
          // Given arrays A and B
          int A[] = { 1, 2, 3 };
          int B[] = { 3, 2, 1 };

          // Sort arrays A and B in ascending order
          Arrays.sort(A);
          Arrays.sort(B);

          // Initialize variable to store the minimum absolute difference
          int minDiff = 0;

          // Iterate over the elements of array A (assuming both arrays are of equal
          // length)
          for (int i = 0; i < A.length; i++) {
               // Calculate the absolute difference between corresponding elements of A and B
               minDiff += Math.abs(A[i] - B[i]);
          }

          // Print the minimum absolute difference between corresponding elements
          System.out.println("Min Absolute Pair are: " + minDiff);

     }
}
