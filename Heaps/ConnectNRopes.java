import java.util.*; // Import all utilities from Java, including PriorityQueue

// Main class to calculate the minimum cost to connect multiple ropes
public class ConnectNRopes {
      public static void main(String[] args) {
            // Array containing lengths of ropes
            int ropes[] = { 2, 3, 3, 4, 6 };

            // Create a PriorityQueue to store and order ropes by length
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

            // Add all ropes to the PriorityQueue
            for (int i = 0; i < ropes.length; i++) {
                  queue.add(ropes[i]); // Add rope length to the queue
            }

            // Initialize the total cost to connect ropes
            int cost = 0;

            // Continue combining ropes until only one rope remains
            while (queue.size() > 1) {
                  // Remove the two shortest ropes from the queue
                  int min1 = queue.remove(); // Get the shortest rope
                  int min2 = queue.remove(); // Get the second shortest rope

                  // Add the cost to combine these two ropes
                  cost += min1 + min2;

                  // Add the combined rope back to the queue
                  queue.add(min1 + min2);
            }

            // Output the total cost of connecting all ropes
            System.out.println("Cost of Ropes is " + cost);
      }
}
