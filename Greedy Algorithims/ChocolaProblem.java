import java.util.*;

public class ChocolaProblem {
     public static void main(String[] args) {
          // Number of rows (vertical cuts) and columns (horizontal cuts) of chocolates
          int n = 4, m = 6;

          // Cost of each vertical cut
          Integer costVer[] = { 2, 1, 3, 1, 4 };
          // Cost of each horizontal cut
          Integer costHor[] = { 4, 1, 2 };

          // Sorting the arrays in descending order to get the most expensive cuts first
          Arrays.sort(costVer, Collections.reverseOrder());
          Arrays.sort(costHor, Collections.reverseOrder());

          // Initial variables to track horizontal and vertical cuts, and pieces
          int h = 0, v = 0; // Indices for horizontal and vertical cuts
          int hp = 1, vp = 1; // Number of horizontal and vertical pieces

          // Total cost of all cuts
          int cost = 0;

          // Loop until one of the arrays is fully processed
          while (h < costHor.length && v < costVer.length) {
               if (costVer[v] <= costHor[h]) {
                    // Horizontal cut is cheaper than or equal to vertical cut
                    // Add cost of horizontal cut to total cost
                    cost += (costHor[h] * vp);
                    // Increase number of horizontal pieces
                    hp++;
                    // Move to the next horizontal cut
                    h++;
               } else {
                    // Vertical cut is cheaper than horizontal cut
                    // Add cost of vertical cut to total cost
                    cost += (costVer[v] * hp);
                    // Increase number of vertical pieces
                    vp++;
                    // Move to the next vertical cut
                    v++;
               }
          }

          // Process remaining horizontal cuts, if any
          while (hp <= costHor.length) {
               // Add cost of horizontal cut to total cost
               cost += (costHor[h] * vp);
               // Increase number of horizontal pieces
               hp++;
               // Move to the next horizontal cut
               h++;
          }

          // Process remaining vertical cuts, if any
          while (vp <= costVer.length) {
               // Add cost of vertical cut to total cost
               cost += (costVer[v] * hp);
               // Increase number of vertical pieces
               vp++;
               // Move to the next vertical cut
               v++;
          }

          // Print the total cost of all cuts
          System.out.println("Cost of total cuts is = " + cost);
     }
}
