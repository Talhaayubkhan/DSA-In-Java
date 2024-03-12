import java.util.*;

public class FractionalKnapsack {
     public static void main(String[] args) {
          // Values and weights of items
          int val[] = { 60, 100, 120 };
          int weight[] = { 10, 20, 30 };
          int W = 50; // Maximum capacity of the knapsack

          // create 2-D Array for the values and weights, if value and weights are
          // not,sorted and we sort it in ascending order
          double ratio[][] = new double[val.length][2];
          // 0th column -> index of the item, 1st column -> value-to-weight ratio

          for (int i = 0; i < val.length; i++) {
               ratio[i][0] = i; // Store index of the item
               ratio[i][1] = val[i] / (double) weight[i]; // Calculate the ratio
          }

          // Sort items based on value-to-weight ratios
          Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

          int capacity = W; // Initialize the remaining capacity of the knapsack
          int finalVal = 0; // Initialize the total value of items selected for the knapsack

          // Iterate through decending order sorted items and add them to the knapsack
          for (int i = ratio.length - 1; i >= 0; i--) {
               int idx = (int) ratio[i][0]; // Get the index of the current item
               if (capacity > weight[idx]) {
                    // If the knapsack has enough capacity, add the entire item
                    finalVal += val[idx];
                    capacity -= weight[idx];
               } else {
                    // If the knapsack does not have enough capacity, add a fraction of the item
                    finalVal += (ratio[i][1] * capacity);
                    capacity = 0; // Set capacity to 0 as the knapsack is full
                    break; // Exit the loop since the knapsack is full
               }
          }

          // Print the total value of items selected for the knapsack
          System.out.println("finalVal: " + finalVal);
     }
}
