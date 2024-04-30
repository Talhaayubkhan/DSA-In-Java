import java.util.*; // Importing the necessary Java utility libraries, including ArrayList.

public class MergeBST {
      // Nested static class to define a binary search tree node.
      static class Node {
            int data; // The value/data stored in the node.
            Node left; // Reference to the left child.
            Node right; // Reference to the right child.

            // Constructor to initialize a node with a given data value.
            Node(int data) {
                  this.data = data; // Assign the given data to the node.
            }
      }

      // Recursive function to perform in-order traversal and collect the node values
      // in a list.
      public static void getInorder(Node root, ArrayList<Integer> arr) {
            if (root == null) { // Base case: If the current node is null, return.
                  return;
            }
            getInorder(root.left, arr); // Recursively traverse the left subtree.
            arr.add(root.data); // Add the current node's data to the list.
            getInorder(root.right, arr); // Recursively traverse the right subtree.
      }

      // Recursive function to create a balanced BST from a sorted array of integers.
      public static Node createBST(ArrayList<Integer> arr, int start, int end) {
            if (start > end) { // Base case: If start index is greater than end index, return null.
                  return null;
            }
            int mid = (start + end) / 2; // Find the middle index of the array.
            Node root = new Node(arr.get(mid)); // Create a new node with the middle value.
            root.left = createBST(arr, start, mid - 1); // Recursively create the left subtree.
            root.right = createBST(arr, mid + 1, end); // Recursively create the right subtree.
            return root; // Return the root node.
      }

      // Function to merge two BSTs into a balanced BST.
      public static Node mergeBSTs(Node root1, Node root2) {
            ArrayList<Integer> arr1 = new ArrayList<>(); // Initialize a list to store in-order traversal of the first
                                                         // BST.
            getInorder(root1, arr1); // Perform in-order traversal on the first BST.

            ArrayList<Integer> arr2 = new ArrayList<>(); // Initialize a list to store in-order traversal of the second
                                                         // BST.
            getInorder(root2, arr2); // Perform in-order traversal on the second BST.

            // Merge the two sorted lists into a final sorted list.
            int i = 0, j = 0; // Initialize indices for the two lists.
            ArrayList<Integer> finalArr = new ArrayList<>(); // Initialize the final sorted list.

            while (i < arr1.size() && j < arr2.size()) { // Loop to merge both lists.
                  if (arr1.get(i) <= arr2.get(j)) { // If the element in the first list is smaller or equal,
                        finalArr.add(arr1.get(i)); // Add it to the final list.
                        i++; // Move to the next element in the first list.
                  } else { // Otherwise, the element in the second list is smaller,
                        finalArr.add(arr2.get(j)); // Add it to the final list.
                        j++; // Move to the next element in the second list.
                  }
            }

            // Add the remaining elements from the first list, if any.
            while (i < arr1.size()) {
                  finalArr.add(arr1.get(i)); // Add remaining elements.
                  i++; // Increment the index.
            }

            // Add the remaining elements from the second list, if any.
            while (j < arr2.size()) { // Corrected from the original code.
                  finalArr.add(arr2.get(j)); // Add remaining elements.
                  j++; // Increment the index.
            }

            // Create a balanced BST from the final sorted list.
            return createBST(finalArr, 0, finalArr.size() - 1); // Return the root of the new BST.
      }

      // Function to perform pre-order traversal on the BST and print the node values.
      public static void preorder(Node root) {
            if (root == null) { // Base case: If the current node is null, return.
                  return;
            }
            System.out.print(root.data + " "); // Print the current node's data.
            preorder(root.left); // Recursively traverse the left subtree.
            preorder(root.right); // Recursively traverse the right subtree.
      }

      // Main function to demonstrate the merging of two BSTs.
      public static void main(String[] args) {
            // Create the first BST with a few nodes.
            Node root1 = new Node(2); // Create the root node.
            root1.left = new Node(1); // Add a left child.
            root1.right = new Node(4); // Add a right child.

            // Create the second BST with a few nodes.
            Node root2 = new Node(9); // Create the root node.
            root2.left = new Node(3); // Add a left child.
            root2.right = new Node(12); // Add a right child.

            // Merge the two BSTs and get the new balanced BST.
            Node root = mergeBSTs(root1, root2); // Merge the BSTs.
            preorder(root); // Perform pre-order traversal to check the result.
      }
}
