import java.util.*;

public class InsertInHeap {
      static class Heap {
            // The internal representation of the heap using an ArrayList
            ArrayList<Integer> arr = new ArrayList<>();

            // Add a new element to the heap
            public void add(int data) {
                  // Add the new element to the end of the array
                  arr.add(data);

                  // Initialize child and parent indices
                  int x = arr.size() - 1; // index of the newly added element
                  int par = (x - 1) / 2; // parent index

                  // Percolate the new element up to maintain the min-heap property
                  while (x > 0 && arr.get(x) < arr.get(par)) {
                        // Swap the child with its parent
                        int temp = arr.get(x);
                        arr.set(x, arr.get(par));
                        arr.set(par, temp);

                        // Update indices for the next iteration
                        x = par; // move to the parent index
                        par = (x - 1) / 2; // calculate the new parent index
                  }
            }

            // Get the top element (minimum) without removing it
            public int peek() {
                  return arr.get(0); // the root of the heap
            }

            // Maintain the min-heap property by "heapifying" a given index
            private void heapify(int i) {
                  // Calculate the indices for the left and right children
                  int left = 2 * i + 1;
                  int right = 2 * i + 2;
                  int minHeapIdx = i; // index of the minimum element

                  // Determine if the left child is smaller than the current minimum
                  if (left < arr.size() && arr.get(minHeapIdx) > arr.get(left)) {
                        minHeapIdx = left;
                  }

                  // Determine if the right child is smaller than the current minimum
                  if (right < arr.size() && arr.get(minHeapIdx) > arr.get(right)) {
                        minHeapIdx = right;
                  }

                  // If the current element is not the minimum, swap and continue heapifying
                  if (minHeapIdx != i) {
                        int temp = arr.get(i);
                        arr.set(i, arr.get(minHeapIdx));
                        arr.set(minHeapIdx, temp);

                        // Recursively heapify from the new minimum index
                        heapify(minHeapIdx);
                  }
            }

            // Remove and return the top element (minimum) from the heap
            public int remove() {
                  // Get the top element to return
                  int data = arr.get(0);

                  // Swap the root with the last element
                  int temp = arr.get(0);
                  arr.set(0, arr.get(arr.size() - 1));
                  arr.set(arr.size() - 1, temp);

                  // Remove the last element
                  arr.remove(arr.size() - 1);

                  // Heapify from the root to restore the min-heap property
                  heapify(0);

                  return data; // return the removed element
            }

            // Check if the heap is empty
            public boolean isEmpty() {
                  return arr.size() == 0; // return true if there are no elements in the heap
            }
      }

      // Main method to test the heap
      public static void main(String[] args) {
            // Create a new heap and add elements to it
            Heap h = new Heap();
            h.add(3);
            h.add(4);
            h.add(1);
            h.add(5);

            // Remove elements from the heap until it is empty
            while (!h.isEmpty()) {
                  System.out.println("Top element before removal: " + h.peek());
                  h.remove(); // remove the top element and heapify
            }
      }
}
