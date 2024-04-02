package BinarySearch;

public class MinDistanceBetweenNodes {

     // Nested static class representing a Node in the binary tree
     public static class Node {
          int data;
          Node left, right;

          // Constructor to initialize a Node with given data
          public Node(int data) {
               this.data = data;
               left = right = null;
          }
     }

     // Method to find the lowest common ancestor (LCA) of two nodes
     // Time Complexity: O(n) where n is the number of nodes in the tree
     public static Node optimizedLca(Node root, int n1, int n2) {
          // If root is null or matches one of the nodes, return root
          if (root == null || root.data == n1 || root.data == n2) {
               return root;
          }

          // Recursively find LCA in left and right subtrees
          Node leftLca = optimizedLca(root.left, n1, n2);
          Node rightLca = optimizedLca(root.right, n1, n2);

          // If one node is found in left subtree and other in right subtree, root is the
          // LCA
          if (leftLca == null) {
               return rightLca;
          }

          if (rightLca == null) {
               return leftLca;
          }

          return root;
     }

     // Method to calculate the distance between LCA and a given node
     // Time Complexity: O(n) where n is the number of nodes in the tree
     public static int lcaDistance(Node root, int n) {
          // If root is null, return -1 indicating node 'n' not found
          if (root == null) {
               return -1;
          }

          // If the current node's data matches 'n', return 0 indicating the distance is 0
          if (root.data == n) {
               return 0;
          }

          // Recursively calculate the distance in the left and right subtrees
          int leftDist = lcaDistance(root.left, n);
          int rightDist = lcaDistance(root.right, n);

          // If 'n' is not found in both left and right subtrees, return -1
          if (leftDist == -1 && rightDist == -1) {
               return -1;
          }
          // If 'n' is found only in the right subtree, return its distance plus 1
          else if (leftDist == -1) {
               return rightDist + 1;
          }
          // If 'n' is found only in the left subtree, return its distance plus 1
          else {
               return leftDist + 1;
          }
     }

     // Method to calculate the minimum distance between two nodes in the binary tree
     // Time Complexity: O(n) where n is the number of nodes in the tree
     public static int minDistance(Node root, int n1, int n2) {

          // Finding the lowest common ancestor of n1 and n2
          Node lca = optimizedLca(root, n1, n2);

          // Calculating the distance between LCA and each of the two nodes
          int dist1 = lcaDistance(lca, n1);
          int dist2 = lcaDistance(lca, n2);

          // Returning the sum of distances
          return dist1 + dist2;
     }

     public static void main(String[] args) {
          // Creating a sample binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);

          int n1 = 4, n2 = 6;
          // Printing the minimum distance between nodes n1 and n2
          System.out.println("Distance between Nodes are = " + minDistance(root, n1, n2));
     }
}
