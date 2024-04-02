package BinarySearch;

public class KthAncestorOfNode {
     // Definition of a Node in the binary tree
     public static class Node {
          int data;
          Node left, right;

          // Constructor to initialize a node with given data
          public Node(int data) {
               this.data = data;
               left = right = null;
          }
     }

     // Time complexity: O(h), where h is the height of the left
     // subtree.
     // Method to find the k-th ancestor of a given node in a binary tree
     public static int kAncestor(Node root, int n, int k) {
          // Base case: If the root is null, return -1
          if (root == null) {
               return -1;
          }

          // Base case: If the root data matches the target node data, return 0
          if (root.data == n) {
               return 0;
          }

          // Recursive calls to find the target node in left and right subtrees
          int leftDist = kAncestor(root.left, n, k);
          int rightDist = kAncestor(root.right, n, k);

          // If the target node is not found in both subtrees, return -1
          if (leftDist == -1 && rightDist == -1) {
               return -1;
          }

          // Calculate the maximum distance between left and right subtrees
          int max = Math.max(leftDist, rightDist);

          // If the maximum distance + 1 equals k, print the value of the current node
          if (max + 1 == k) {
               System.out.println(root.data);
          }

          // Return the distance of the current node from the target node
          return max + 1;
     }

     // Main method to test the kAncestor method
     public static void main(String[] args) {
          // Creating a sample binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);

          int n = 5, k = 1; // Finding 2nd ancestor of node 5
          kAncestor(root, n, k);
     }
}
