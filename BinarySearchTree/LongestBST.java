import java.util.*; // Importing standard Java utility packages

public class LongestBST { // Class to find the largest BST in a binary tree

      // Node class representing a node in the binary tree
      static class Node {
            int data; // The value/data stored in the node
            Node left; // Left child reference
            Node right; // Right child reference

            // Constructor to initialize a node with a given data value
            Node(int data) {
                  this.data = data; // Assigning the given data to the node
                  this.left = null; // Initialize the left child reference to null
                  this.right = null; // Initialize the right child reference to null
            }
      }

      // Info class used to store information about a subtree
      static class Info {
            boolean BST; // Flag indicating if the subtree is a BST
            int size; // Size of the subtree (number of nodes)
            int min; // Minimum value in the subtree
            int max; // Maximum value in the subtree

            // Constructor to initialize an Info object with given attributes
            public Info(boolean BST, int size, int min, int max) {
                  this.BST = BST; // Setting if the subtree is a BST
                  this.size = size; // Setting the size of the subtree
                  this.min = min; // Setting the minimum value in the subtree
                  this.max = max; // Setting the maximum value in the subtree
            }
      }

      public static int maxBST = 0; // Global variable to track the size of the largest BST found

      // Method to find information about the largest BST in a given binary tree
      public static Info largestBST(Node root) {
            // If the root is null, it's an empty tree, which is a valid BST with size 0
            if (root == null) {
                  return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            // Recursively find information about the left subtree
            Info leftInfo = largestBST(root.left);
            // Recursively find information about the right subtree
            Info rightInfo = largestBST(root.right);

            // Calculate the total size of the current subtree (including the root node)
            int size = leftInfo.size + rightInfo.size + 1;

            // Determine the minimum value in the current subtree
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            // Determine the maximum value in the current subtree
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            // Check if the current tree violates the BST property
            if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
                  // If the BST property is violated, return an Info object indicating it's not a
                  // BST
                  return new Info(false, size, min, max);
            }

            // If both left and right subtrees are valid BSTs
            if (leftInfo.BST && rightInfo.BST) {
                  // Update the global maximum BST size if the current subtree is the largest
                  maxBST = Math.max(maxBST, size);
                  // Return an Info object indicating this subtree is a valid BST
                  return new Info(true, size, min, max);
            }

            // If the current subtree is not a valid BST, return the Info indicating so
            return new Info(false, size, min, max);
      }

      // Main method to test the code functionality
      public static void main(String[] args) {
            // Creating a sample binary tree
            Node root = new Node(50); // Root node with value 50
            root.left = new Node(30); // Left child with value 30
            root.left.left = new Node(5); // Left-left grandchild with value 5
            root.left.right = new Node(20); // Left-right grandchild with value 20

            root.right = new Node(60); // Right child with value 60
            root.right.left = new Node(45); // Right-left grandchild with value 45
            root.right.right = new Node(70); // Right-right child with value 70
            root.right.right.left = new Node(65); // Right-right-left grandchild with value 65
            root.right.right.right = new Node(80); // Right-right-right grandchild with value 80

            // Call the largestBST method to find the largest BST in the tree
            Info info = largestBST(root);

            // Output the size of the largest BST found in the given tree
            System.out.println("Largest BST size = " + maxBST);
      }
}
