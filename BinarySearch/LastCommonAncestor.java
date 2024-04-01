package BinarySearch;

import java.util.*;

public class LastCommonAncestor {
     // Node class representing a node in the binary tree
     public static class Node {
          int data;
          Node left, right;

          // Constructor to initialize a node with data
          public Node(int data) {
               this.data = data;
               left = right = null;
          }
     }

     // Method to find the path from the root to a given node
     // Time Complexity: O(n), where n is the number of nodes in the tree
     public static boolean getPath(Node root, int n, ArrayList<Node> path) {
          // If the root is null, return false
          if (root == null) {
               return false;
          }
          // Add the current node to the path
          path.add(root);

          // If the current node's data matches the target node's data, return true
          if (root.data == n) {
               return true;
          }

          // Recursively search for the node in the left and right subtrees
          boolean foundLeft = getPath(root.left, n, path);
          boolean foundRight = getPath(root.right, n, path);

          // If the node is found in either subtree, return true
          if (foundLeft || foundRight) {
               return true;
          }

          // If the node is not found in either subtree, remove the current node from the
          // path and return false
          path.remove(path.size() - 1);
          return false;
     }

     // Method to find the Least Common Ancestor (LCA) of two nodes (less optimized
     // approach)
     // Time Complexity: O(n), where n is the number of nodes in the tree
     public static Node lca(Node root, int n1, int n2) {
          // Create ArrayLists to store paths from the root to n1 and n2
          ArrayList<Node> path1 = new ArrayList<>();
          ArrayList<Node> path2 = new ArrayList<>();

          // Get paths from the root to n1 and n2
          getPath(root, n1, path1);
          getPath(root, n2, path2);

          // Calculate the last common ancestor
          int i = 0;
          for (; i < path1.size() && i < path2.size(); i++) {
               // Find the last common node between the two paths
               if (path1.get(i) != path2.get(i)) {
                    break;
               }
          }

          // Last equal node is the LCA
          Node lca = path1.get(i - 1);
          return lca;
     }

     // Method to find the Least Common Ancestor (LCA) of two nodes (optimized
     // approach)
     // Time Complexity: O(n), where n is the number of nodes in the tree
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

     // Main method to test the LCA functionality
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
          // Printing the data of the Least Common Ancestor of nodes n1 and n2
          System.out.println(lca(root, n1, n2).data);
     }
}
