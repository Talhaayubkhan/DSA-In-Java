package BinarySearch;

public class SumOfNodes {
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

     // Function to calculate the sum of all nodes in a binary tree
     // Time Complexity: O(n), where n is the number of nodes in the binary tree
     public static int sumOfNodes(Node root) {
          // If the root is null, return 0
          if (root == null) {
               return 0;
          }

          // Recursively calculate the sum of nodes in the left subtree
          int leftSum = sumOfNodes(root.left);
          // Recursively calculate the sum of nodes in the right subtree
          int rightSum = sumOfNodes(root.right);

          // Total sum is the sum of sums in the left subtree, right subtree, and the
          // value of the root itself
          return leftSum + rightSum + root.data;
     }

     public static void main(String[] args) {
          // Create the binary tree
          Node root = new Node(1);
          // Adding left and right children to the root
          root.left = new Node(2);
          root.right = new Node(3);
          // Adding left and right children to the left child of the root
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          // Adding left child to the right child of the root
          root.right.left = new Node(6);
          // Uncomment the line below to add a right child to the right child of the root
          // root.right.right = new Node(7);

          // Print the sum of all nodes in the binary tree
          System.out.println("Sum of Nodes: " + sumOfNodes(root));
     }
}
