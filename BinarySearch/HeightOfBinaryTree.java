package BinarySearch;

import java.util.*;

public class HeightOfBinaryTree {
     // Node class to represent each node of the binary tree
     public static class Node {
          int data;
          Node left;
          Node right;

          // Constructor to initialize a node with given data
          public Node(int data) {
               this.data = data;
               this.left = null;
               this.right = null;
          }
     }

     // Method to calculate the height of a binary tree
     public static int binaryTreeHeight(Node root) {
          // Base case: If the root is null, height is 0
          if (root == null)
               return 0;

          // Recursive calls to find the heights of left and right subtrees
          int lh = binaryTreeHeight(root.left);
          int rh = binaryTreeHeight(root.right);

          // Return the maximum of left and right subtree heights, plus 1 for the current
          // node
          return Math.max(lh, rh) + 1;
     }

     // Main method to create a binary tree and calculate its height
     public static void main(String[] args) {
          // Create the binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);

          // Print the height of the binary tree
          System.out.println(binaryTreeHeight(root));
     }
}
