import java.util.*;

public class InsertInHeap {
      // Define a static inner class `Heap` to represent a min-heap.
      static class Heap {
            // Use an ArrayList to dynamically store heap elements.
            ArrayList<Integer> arr = new ArrayList<>();

            // Method to add a new element to the heap.
            public void add(int data) {
                  // Add the new element to the last index of the array.
                  arr.add(data);

                  // Get the index of the newly added element.
                  int x = arr.size() - 1;

                  // Calculate the index of its parent.
                  int par = (x - 1) / 2;

                  // Loop to maintain the min-heap property by percolating up.
                  while (x > 0 && arr.get(x) < arr.get(par)) {
                        // Swap the child with its parent if the child is smaller.
                        int temp = arr.get(x); // Temporary storage for the child element.
                        arr.set(x, arr.get(par)); // Move the parent to the child's position.
                        arr.set(par, temp); // Move the child to the parent's position.

                        // Update the current index to the parent for the next iteration.
                        x = par;
                        par = (x - 1) / 2; // Recalculate the parent index.
                  }
            }

            // Method to get the top element (the smallest one) without removing it.
            public int peek() {
                  return arr.get(0); // Return the root of the heap.
            }

            // Method to ensure the heap property is maintained.
            private void heapify(int i) {
                  // Calculate the indices of the left and right children.
                  int left = 2 * i + 1; // Left child index.
                  int right = 2 * i + 2; // Right child index.

                  // Start with the current index as the minimum.
                  int minHeapIdx = i;

                  // Check if the left child exists and is smaller than the current minimum.
                  if (left < arr.size() && arr.get(minHeapIdx) > arr.get(left)) {
                        minHeapIdx = left; // Update the minimum index to the left child.
                  }

                  // Check if the right child exists and is smaller than the current minimum.
                  if (right < arr.size() && arr.get(minHeapIdx) > arr.get(right)) {
                        minHeapIdx = right; // Update the minimum index to the right child.
                  }

                  // If the current index is not the minimum, perform a swap to maintain the heap
                  // property.
                  if (minHeapIdx != i) {
                        // Swap the current index with the new minimum index.
                        int temp = arr.get(i); // Temporarily store the current value.
                        arr.set(i, arr.get(minHeapIdx)); // Move the minimum child to the current index.
                        arr.set(minHeapIdx, temp); // Set the original current value to the new minimum index.

                        // Recursively call `heapify` on the new minimum index to ensure the heap
                        // property is restored.
                        heapify(minHeapIdx); // Continue heapifying from the new position.
                  }
            }

            // Method to remove and return the top element (minimum) from the heap.
            public int remove() {
                  // Get the top element to return.
                  int data = arr.get(0);

                  // Swap the first and last elements.
                  int temp = arr.get(0);
                  arr.set(0, arr.get(arr.size() - 1)); // Move the last element to the root.
                  arr.set(arr.size() - 1, temp); // Move the root to the last index.

                  // Remove the last element from the array.
                  arr.remove(arr.size() - 1);

                  // Call `heapify` from the root to maintain the min-heap property.
                  heapify(0); // Start restoring the heap from the root.

                  return data; // Return the removed element.
            }

            // Method to check if the heap is empty.
            public boolean isEmpty() {
                  return arr.size() == 0; // Return true if the heap has no elements.
            }
      }

      // Main method to test the heap functionality.
      public static void main(String[] args) {
            // Create a new heap and add several elements.
            Heap h = new Heap();
            h.add(3); // Add elements to the heap.
            h.add(4);
            h.add(1);
            h.add(5);

            // Loop while the heap is not empty.
            while (!h.isEmpty()) {
                  // Print the top element before removing it.
                  System.out.println("Top element before removal: " + h.peek());

                  // Remove the top element and restore the heap structure.
                  h.remove();
            }
      }
}
