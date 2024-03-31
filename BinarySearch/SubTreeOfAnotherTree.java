package BinarySearch;

// Class definition for checking if one binary tree is a subtree of another binary tree
public class SubTreeOfAnotherTree {
     // Nested static class representing a node in a binary tree
     public static class Node {
          int data;
          Node left, right;

          // Constructor to initialize a node with given data
          public Node(int data) {
               this.data = data;
               left = right = null;
          }

     }

     // Method to check if two binary trees rooted at 'node' and 'subTree' are
     // identical
     public static boolean isIdentical(Node node, Node subTree) {
          // Base case: If both 'node' and 'subTree' are null, they are identical
          if (node == null && subTree == null) {
               return true;
          }
          // If either 'node' or 'subTree' is null or their data values are different,
          // they are not identical
          else if (node == null || subTree == null || node.data != subTree.data) {
               return false;
          }

          // Recursively check if the left subtrees and right subtrees are identical
          if (!isIdentical(node.left, subTree.left)) {
               return false;
          }
          if (!isIdentical(node.right, subTree.right)) {
               return false;
          }

          // If all checks pass, the trees rooted at 'node' and 'subTree' are identical
          return true;
     }

     // Method to check if 'subTree' is a subtree of 'root'
     public static boolean isSubtree(Node root, Node subTree) {
          // Base case: If 'root' is null, 'subTree' cannot be a subtree
          if (root == null) {
               return false;
          }
          // If the data of 'root' matches the data of 'subTree', check if they are
          // identical
          if (root.data == subTree.data) {
               if (isIdentical(root, subTree)) {
                    return true;
               }
          }

          // Recursively check if 'subTree' is a subtree of the left or right subtree of
          // 'root'
          return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
     }

     // Main method to execute the program
     public static void main(String[] args) {
          // Create the main binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);

          // Create the subtree to be checked
          Node subTree = new Node(2);
          subTree.left = new Node(4);
          subTree.right = new Node(5);

          // Check if 'subTree' is a subtree of 'root' and print the result
          System.out.println(isSubtree(root, subTree));
     }
}
