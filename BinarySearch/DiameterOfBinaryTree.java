package BinarySearch;

// Class to calculate the diameter of a binary tree
public class DiameterOfBinaryTree {

     // Inner class representing a node in the binary tree
     public static class Node {
          int data; // Data stored in the node
          Node left, right; // References to the left and right child nodes

          // Constructor to initialize a node with data
          public Node(int data) {
               this.data = data;
               left = right = null; // Initialize left and right child nodes as null
          }
     }

     // Method to calculate the height of a binary tree
     public static int binaryTreeHeight(Node root) {
          // Base case: If the root is null, height is 0
          if (root == null)
               return 0;

          // Recursive calls to find the heights of left and right subtrees
          int lh = binaryTreeHeight(root.left); // Height of the left subtree
          int rh = binaryTreeHeight(root.right); // Height of the right subtree

          // Return the maximum of left and right subtree heights, plus 1 for the current
          // node
          return Math.max(lh, rh) + 1; // Add 1 for the current node
     }

     // Method to calculate the diameter of a binary tree
     public static int diameterOfBinaryTree(Node root) {
          if (root == null) {
               return 0; // Base case: if the root is null, diameter is 0
          }

          // Recursively calculate the diameter and heights of the left and right subtrees
          int leftDiameter = diameterOfBinaryTree(root.left); // Diameter of the left subtree
          int leftHeight = binaryTreeHeight(root.left); // Height of the left subtree
          int rightDiameter = diameterOfBinaryTree(root.right); // Diameter of the right subtree
          int rightHeight = binaryTreeHeight(root.right); // Height of the right subtree

          // Calculate the diameter passing through the current node
          int selfDiameter = leftHeight + rightHeight + 1; // Diameter = left height + right height + 1

          // Find the maximum diameter among the left subtree, right subtree, and through
          // the current node
          int maxDiameter = Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);

          return maxDiameter; // Return the maximum diameter
     }

     // Main method to test the functionality
     public static void main(String[] args) {

          // Create the binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          // root.right.right = new Node(7);

          // Calculate and print the diameter of the tree
          System.out.println("Diameter of Tree is " + diameterOfBinaryTree(root));
     }
}
