import java.util.*;

public class ChocolaProblem {
     public static void main(String[] args) {
          // Dimensions of the chocolate bar
          int n = 4, m = 6;

          // Costs of vertical and horizontal cuts
          Integer[] costVer = { 2, 1, 3, 1, 4 };
          Integer[] costHor = { 4, 1, 2 };

          // Sorting arrays in descending order to prioritize higher costs
          Arrays.sort(costVer, Comparator.reverseOrder());
          Arrays.sort(costHor, Comparator.reverseOrder());

          // Initializing variables
          int h = 0, v = 0; // Indices for horizontal and vertical cuts
          int hp = 1; // Horizontal pieces counter
          int vp = 1; // Vertical pieces counter
          int cost = 0; // Total cost of cutting

          // Loop until either of the arrays are fully traversed
          while (h < costHor.length && v < costHor.length) {
               // Performing horizontal cut if cost of vertical cut is less than or equal to
               // horizontal cut
               if (costVer[v] <= costHor[h]) {
                    cost += (costHor[h] * vp); // Accumulating the cost of a horizontal cut to the total cost
                    hp++; // Increment horizontal pieces counter
                    h++; // Move to next horizontal cut
               } else { // Performing vertical cut
                    cost += (costVer[v] * hp); // Accumulating the cost of a vertical cut to the total cost
                    vp++; // Increment vertical pieces counter
                    v++; // Move to next vertical cut
               }
          }

          // Handling remaining horizontal cuts
          while (h < costHor.length) {
               cost += (costHor[h] * vp); // Accumulating the cost of a horizontal cut to the total cost
               hp++; // Increment horizontal pieces counter
               h++; // Move to next horizontal cut
          }

          // Handling remaining vertical cuts
          while (v < costVer.length) {
               cost += (costVer[v] * hp); // Accumulating the cost of a vertical cut to the total cost
               vp++; // Increment vertical pieces counter
               v++; // Move to next vertical cut
          }

          // Printing total cost
          System.out.println("total cost: " + cost);
     }
}
