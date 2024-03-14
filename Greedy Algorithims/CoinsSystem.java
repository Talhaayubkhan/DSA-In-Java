import java.util.*;

public class CoinsSystem {
     public static void main(String[] args) {
          // Define an array of coins
          Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000, 2000 };

          // Sort the coins in descending order
          Arrays.sort(coins, Comparator.reverseOrder());

          // Initialize variables for coin count and amount
          int coinCount = 0;
          int amount = 590;

          // Create an ArrayList to store the coins
          ArrayList<Integer> ans = new ArrayList<>();

          // Loop through the coins
          for (int i = 0; i < coins.length; i++) {
               // If the current coin is less than or equal to the amount
               if (coins[i] <= amount) {
                    // Keep adding the current coin denomination until it's no longer possible
                    while (coins[i] <= amount) {
                         // Increment the coin count
                         coinCount++;
                         // Add the current coin to the ArrayList
                         ans.add(coins[i]);
                         // Subtract the current coin from the amount
                         amount -= coins[i];
                    }
               }
          }

          // Print the maximum coin count and the coins in the ArrayList
          System.out.println("Max coin count: " + coinCount);
          for (int i = 0; i < ans.size(); i++) {
               System.out.print(ans.get(i) + " ");
          }
          System.out.println();
     }
}
