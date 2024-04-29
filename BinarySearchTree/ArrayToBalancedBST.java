public class ArrayToBalancedBST {
      // Define a static nested class representing a binary tree node
      static class Node {
            int data; // The value/data stored in the node
            Node left; // Left child reference
            Node right; // Right child reference

            // Constructor to initialize a node with a given data value
            Node(int data) {
                  this.data = data; // Set the node's data to the given value
            }
      }

      // Function to perform a preorder traversal of the binary tree
      public static void preorder(Node root) {
            // If the current node is null, return (base case)
            if (root == null)
                  return; // End the recursion

            System.out.print(root.data + " "); // Print the node's data
            // Recursively traverse the left subtree
            preorder(root.left);
            // Recursively traverse the right subtree
            preorder(root.right);
      }

      // Function to create a balanced binary search tree from a sorted array
      public static Node createSortedBST(int[] arr, int start, int end) {
            // Base case: if the start index is greater than the end index
            if (start > end) {
                  return null; // Return null to indicate no node should be created
            }

            // Calculate the middle index to determine the root node
            int mid = (start + end) / 2;
            // Create a new node with the value from the middle index of the array
            Node root = new Node(arr[mid]);

            // Recursively create the left subtree using the left half of the array
            root.left = createSortedBST(arr, start, mid - 1);

            // Recursively create the right subtree using the right half of the array
            root.right = createSortedBST(arr, mid + 1, end);

            return root; // Return the root node
      }

      public static void main(String[] args) {
            // An array of sorted integers to build the balanced BST
            int[] arr = { 3, 5, 6, 8, 10, 11, 12 };

            // Create a balanced BST from the array using the start and end indices
            Node root = createSortedBST(arr, 0, arr.length - 1);

            // Perform a preorder traversal of the constructed BST
            preorder(root);
      }
}
