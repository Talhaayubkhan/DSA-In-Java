import java.util.*;

public class SortArrayOfZerosAndOnes {
      public static void sortAnArray(ArrayList<Integer> arr, int n) {
            int low = 0, mid = 0, high = n - 1;
            // the overall time complexity is 𝑂(𝑛)
            while (mid <= high) {
                  if (arr.get(mid) == 0) {
                        // Swap the elements at indices 'low' and 'mid'
                        int temp = arr.get(low);
                        arr.set(low, arr.get(mid));
                        arr.set(mid, temp);

                        // Increment 'low' and 'mid' to move to the next elements
                        low++;
                        mid++;
                  }
                  // If the current element is 1
                  else if (arr.get(mid) == 1) {
                        // Simply move the 'mid' pointer to the next element
                        mid++;
                  }
                  // If the current element is 2
                  else {
                        // Swap the elements at indices 'mid' and 'high'
                        int temp = arr.get(mid);
                        arr.set(mid, arr.get(high));
                        arr.set(high, temp);

                        // Decrement 'high' to move the boundary for placing 2s

                        high--;
                  }
            }
      }

      public static void main(String[] args) {
            int n = 13;
            ArrayList<Integer> arr = new ArrayList<>(
                        Arrays.asList(new Integer[] { 0, 2, 1, 0, 0, 2, 1, 2, 2, 2, 1, 0, 1 }));
            sortAnArray(arr, n);

            System.out.println("After Sort the Array is");
            for (int i = 0; i < n; i++) {
                  System.out.print(arr.get(i) + " ");
            }
            System.out.println();
      }
}
