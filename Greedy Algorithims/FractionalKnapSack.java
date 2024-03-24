import java.util.*;

public class FractionalKnapSack {
     public static void main(String[] args) {
          // Values of items available
          int value[] = { 60, 100, 120 };

          // Weights of items available
          int weight[] = { 10, 20, 30 };

          // Total weight capacity of the knapsack
          int w = 50;

          // Creating a 2D array to store item indices and their value-to-weight ratios
          double ratio[][] = new double[value.length][2];

          // Calculating value-to-weight ratios for each item and storing them along with
          // item indices
          for (int i = 0; i < value.length; i++) {
               ratio[i][0] = i; // Storing item index
               ratio[i][1] = value[i] / (double) weight[i]; // Calculating and storing
          }

          // Sorting the items based on their value-to-weight ratios in ascending order
          Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

          // Reversing the order to get descending order
          int capacity = w; // Current capacity of the knapsack
          int finalVal = 0; // Final total value of items selected

          // Iterating through the items sorted by value-to-weight ratio in descending
          // order
          for (int i = ratio.length - 1; i >= 0; i--) {
               int idx = (int) ratio[i][0]; // Getting the index of the item
               if (capacity > weight[idx]) {
                    // If the entire item can be included in the knapsack
                    finalVal += value[idx]; // Add its value to the total value
                    capacity -= weight[idx]; // Reduce the remaining capacity of the knapsack
               } else {
                    // If only a fraction of the item can be included
                    finalVal += (ratio[i][1] * capacity); // Add fractional value to the total value
                    capacity = 0; // Set capacity to 0 to stop further inclusion
                    break; // Exit the loop since knapsack is full
               }
          }

          // Printing the total value of items selected
          System.out.println("Total value = " + finalVal);
     }
}
