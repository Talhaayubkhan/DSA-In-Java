import java.util.*;

public class MajorityElementInArray {
      public static int findMajorityElement(int arr[]) {
            // this is brute force approach
            // Time complexity is O(n^2)
            int n = arr.length - 1;

            for (int i = 0; i < n; i++) {
                  int count = 0;

                  for (int j = 0; j < n; j++) {
                        if (arr[i] == arr[j]) {
                              count++;
                        }
                  }

                  if (count > (n / 2)) {
                        return arr[i];
                  }
            }
            return -1; // No majority element found
      }

      public static int majorityElementCount(int arr[]) {
            // This Better approach implementation
            // overall time complexity of the majorityElementCount method is O(n)
            // the space complexity of the majorityElementCount method is O(n), primarily
            // due to the HashMap m used to store counts of array elements
            int n = arr.length;

            HashMap<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                  int count = m.getOrDefault(arr[i], 0);
                  m.put(arr[i], count + 1);
            }

            for (Map.Entry<Integer, Integer> it : m.entrySet()) {
                  if (it.getValue() > (n / 2)) {
                        return it.getKey();
                  }
            }

            return -1; // No majority element found
      }

      public static int majorityElementFind(int arr[]) {
            int n = arr.length;
            int count = 0; // Counter for the potential majority element
            int element = 0; // Variable to store the potential majority element

            // First pass: Identify potential majority element using Boyer-Moore Voting
            // Algorithm
            for (int i = 0; i < n; i++) {
                  if (count == 0) {
                        count = 1; // Initialize count to 1 for the current element
                        element = arr[i]; // Set the current element as potential majority element
                  } else if (arr[i] == element) {
                        count++; // Increment count if current element matches potential majority element
                  } else {
                        count--; // Decrement count if current element does not match potential majority element
                  }
            }

            int count1 = 0; // Counter to verify the occurrence of the potential majority

            // Second pass: Verify if the identified element is the majority element
            for (int i = 0; i < n; i++) {
                  if (arr[i] == element) {
                        count1++; // Count occurrences of the potential majority element
                  }
                  if (count1 > (n / 2)) {
                        return element;
                  }
            }
            return -1;

      }

      public static void main(String[] args) {
            int arr[] = { 2, 4, 4, 2, 2, 2 };
            int result = majorityElementFind(arr);
            if (result != -1) {
                  System.out.println("Majority element is: " + result);
            } else {
                  System.out.println("No majority element found");
            }

            // int result = majorityElementCount(arr);
            // if (result != -1) {
            // System.out.println("Majority element is: " + result);
            // } else {
            // System.out.println("No majority element found");
            // }
            // int result = findMajorityElement(arr);
            // if (result != -1) {
            // System.out.println("Majority element is: " + result);
            // } else {
            // System.out.println("No majority element found");
            // }
      }
}
