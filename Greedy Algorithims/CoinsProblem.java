import java.util.*;

public class CoinsProblem {
     public static void main(String[] args) {
          // Define coin denominations in descending order
          Integer coins[] = { 2000, 500, 100, 50, 20, 10, 5, 2, 1 };

          // Define total amount for which minimum number of coins need to be found
          int amount = 1000;

          // Initialize variables to keep track of coins used and selected coins
          int count = 0;
          ArrayList<Integer> selectedCoins = new ArrayList<>();

          // Iterate through each coin denomination
          for (int i = 0; i < coins.length; i++) {
               // Check if the current coin denomination is less than or equal to the remaining
               // amount
               if (coins[i] <= amount) {
                    // Keep selecting the current coin denomination until its value is less than or
                    // equal to the remaining amount
                    while (coins[i] <= amount) {
                         // Increment the count of coins used
                         count++;
                         // Add the current coin denomination to the list of selected coins
                         selectedCoins.add(coins[i]);
                         // Update the remaining amount by subtracting the value of the selected coin
                         amount -= coins[i];
                    }
               }
          }

          // Print the total number of coins used
          System.out.println("Total coins used: " + count);

          // Print the selected coins
          System.out.print("Selected coins: ");
          for (int i = 0; i < selectedCoins.size(); i++) {
               System.out.print(selectedCoins.get(i) + " "); // Print each selected coin denomination
          }
          System.out.println(); // Move to the next line after printing the selected coins
     }
}
