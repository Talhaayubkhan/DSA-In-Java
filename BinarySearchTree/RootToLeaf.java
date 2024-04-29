import java.util.*;

public class RootToLeaf {
      static class Node {
            int data;
            Node left;
            Node right;

            // Constructor to initialize a node with given data
            Node(int data) {
                  this.data = data;
            }
      }

      public static Node insert(Node root, int values) {
            // If the tree is empty, create a new node with the given value
            if (root == null) {
                  root = new Node(values);
                  return root;
            }

            // If the value is less than the current node's data, insert into the left
            // subtree
            if (root.data > values) {
                  root.left = insert(root.left, values);
            }
            // If the value is greater than the current node's data, insert into the right
            // subtree
            else {
                  root.right = insert(root.right, values);
            }
            return root;
      }

      public static void inOrder(Node root) {
            // Base case: if the tree is empty, return
            if (root == null) {
                  return;
            }
            // Traverse the left subtree
            inOrder(root.left);
            // Print the current node's data
            System.out.print(root.data + " ");
            // Traverse the right subtree
            inOrder(root.right);
      }

      public static void printPath(ArrayList<Integer> path) {
            for (int i = 0; i < path.size(); i++) {
                  System.out.print(path.get(i) + " ");
            }
            System.out.println();
      }

      public static void rootToLeaf(Node root, ArrayList<Integer> path) {
            // Base case: if the current node is null, return to avoid further recursion
            if (root == null) {
                  return;
            }

            // Add the current node's data to the path to represent the current root-to-leaf
            // path
            path.add(root.data);

            // If the current node is a leaf (no left or right child), print the complete
            // path
            if (root.left == null && root.right == null) {
                  printPath(path); // Print the path from root to this leaf
            }

            // Recur into the left subtree to explore other potential root-to-leaf paths
            rootToLeaf(root.left, path);

            // Recur into the right subtree to explore more paths
            rootToLeaf(root.right, path);

            // After exploring both subtrees, remove the last node from the path to
            // backtrack
            // This step ensures the current path stays accurate as the recursion unwinds
            path.remove(path.size() - 1); // Backtrack by removing the last node from the path
      }

      public static void main(String[] args) {
            int values[] = { 8, 5, 3, 6, 10, 11, 14 };
            Node root = null;
            for (int i = 0; i < values.length; i++) {
                  root = insert(root, values[i]);
            }

            inOrder(root);
            System.out.println();

            rootToLeaf(root, new ArrayList<>());
      }

}
