import java.util.*;

public class TwoSum {
      public static int[] findTwoSum(int[] arr, int target) {
            // brute force
            // time complexity is O(n^2)
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] + arr[j] == target) {
                              return new int[] { arr[i], arr[j] };
                        }
                  }
            }
            return new int[0]; // No pair found that sums up to the target
      }

      // Each iteration performs a constant amount of work O(1) for the containsKey,
      // get, and put operations in the HashMap.Therefore, the overall time complexity
      // of the twoSumFind function is: O(n)
      public static int[] twoSumFind(int[] arr, int target) {
            int n = arr.length;
            // this hash operation take O(N) time
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                  int nums = arr[i];
                  int neededNum = target - nums;

                  if (map.containsKey(neededNum)) {
                        return new int[] { map.get(neededNum), i };
                  }
                  map.put(nums, i);
            }
            return new int[0]; // No pair found that sums up to the target
      }

      // Time Complexity: O(n log n) due to the sorting step using Arrays.sort(arr),
      // where n is the number of elements in the array arr.
      public static int[] twoSum(int[] arr, int target) {
            Arrays.sort(arr);

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                  int sumOfLeftAndRight = arr[left] + arr[right];
                  if (sumOfLeftAndRight == target) {
                        // if we print numbers not indices
                        return new int[] { arr[left], arr[right] };
                        // return new int[] { left, right }; // if we print indices
                  } else if (sumOfLeftAndRight < target) {
                        left++;
                  } else {
                        right--;
                  }

            }
            return new int[0]; // No pair found that sums up to the target

      }

      public static void main(String[] args) {
            int arr[] = { 2, 6, 5, 8, 11 };
            int target = 14;
            int[] result = twoSum(arr, target);
            if (result.length == 0) {
                  System.out.println("No pair found that sums up to the target.");
            } else {
                  System.out.println("Pair found: " + result[0] + " + " + result[1] + " = " + target);
            }

            // int[] result = twoSumFind(arr, target);
            // if (result.length == 0) {
            // System.out.println("No pair found that sums up to the target.");
            // } else {
            // System.out.println("Pair found at index: " + result[0] + " + " + result[1]);
            // }
            // int[] result = findTwoSum(arr, target);
            // if (result.length == 0) {
            // System.out.println("No pair found that sums up to the target.");
            // } else {
            // System.out.println("Pair found: " + result[0] + " + " + result[1] + " = " +
            // target);
            // }

      }
}
