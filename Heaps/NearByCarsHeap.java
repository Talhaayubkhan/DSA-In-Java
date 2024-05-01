import java.util.*;

// Main class for handling a heap-based data structure to find nearby cars
public class NearByCarsHeap {

      // Nested static class representing a point with coordinates, distance, and
      // index
      static class Point implements Comparable<Point> {
            int distance; // Squared distance from the origin (0, 0)
            int x; // X-coordinate of the point
            int y; // Y-coordinate of the point
            int idx; // Index of the point in the original array

            // Constructor to initialize a Point with given coordinates, distance, and index
            public Point(int x, int y, int distance, int idx) {
                  this.x = x; // Set the X-coordinate
                  this.y = y; // Set the Y-coordinate
                  this.distance = distance; // Set the squared distance
                  this.idx = idx; // Set the index
            }

            // Method to compare points based on their squared distance
            @Override
            public int compareTo(Point p2) {
                  // Comparing based on the squared distance to determine priority in the heap
                  return this.distance - p2.distance; // Return the difference in distances
            }
      }

      // Main method for running the program
      public static void main(String[] args) {
            // Define a 2D array with the coordinates of points
            int arr[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

            // The number of closest points to retrieve
            int k = 2;

            // Create a priority queue to keep points sorted by distance
            PriorityQueue<Point> q = new PriorityQueue<Point>();

            // Loop through all points in 'arr'
            for (int i = 0; i < arr.length; i++) {
                  // Calculate the squared Euclidean distance from the origin (x^2 + y^2)
                  int distance = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];

                  // Add the point to the priority queue with the calculated distance and index
                  q.add(new Point(arr[i][0], arr[i][1], distance, i));
            }

            // Retrieve the 'k' closest points by removing them from the priority queue
            for (int i = 0; i < k; i++) {
                  // Print the index of the point, indicating its relative order
                  System.out.println("C" + q.remove().idx); // Output the index of the point
            }
      }
}
