package Hashing; // Package declaration for organization of related classes

import java.util.*; // Importing necessary Java utilities like HashMap

public class MajorityElements { // Class definition for MajorityElements

      // Method to find and print elements that appear more than one-third of the
      // total array length
      public static void printMajorityElement(int arr[]) {
            // Create a HashMap to count occurrences of each element in the array
            HashMap<Integer, Integer> map = new HashMap<>();

            // Iterate over the array to count the occurrences of each element
            for (int i = 0; i < arr.length; i++) {
                  // Use getOrDefault to count existing occurrences or start with zero if not
                  // found
                  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            // Iterate over the keys in the HashMap to find majority elements
            for (Integer key : map.keySet()) { // Loop through all keys in the map
                  // Check if the count for this key is greater than one-third of the array length
                  if (map.get(key) > arr.length / 3) { // Condition to check if this key is a majority element
                        // Print the key if it is a majority element
                        System.out.println(key + " "); // Print the majority element followed by a space
                  }
            }
      }

      public static void main(String[] args) { // Main method where the program starts execution
            // An array of integers to test the majority element functionality
            int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

            // Call the method to find and print the majority elements
            printMajorityElement(arr); // Find and print majority elements in the given array
      }
}
