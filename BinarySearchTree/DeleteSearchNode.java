public class DeleteSearchNode {
      // Define a static class Node to represent a node in the binary search tree
      static class Node {
            int data;
            Node left;
            Node right;

            // Constructor to initialize a node with given data
            Node(int data) {
                  this.data = data;
            }
      }

      // Method to insert a value into the binary search tree
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

      // Method to perform in-order traversal of the binary search tree
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

      // Method to delete a node with the given value from the binary search tree
      public static Node delete(Node root, int values) {
            // If the tree is empty, return null
            if (root == null) {
                  return null;
            }

            // If the value is less than the current node's data, move to the right subtree
            if (root.data < values) {
                  root.right = delete(root.right, values);
            }
            // If the value is greater than the current node's data, move to the left
            // subtree
            else if (root.data > values) {
                  root.left = delete(root.left, values);
            }
            // If the value is equal to the current node's data, this is the node to be
            // deleted
            else {
                  // Case 1: If the node to be deleted has no children (leaf node), return null
                  if (root.left == null && root.right == null) {
                        return null;
                  }
                  // Case 2: If the node to be deleted has one child, return the child node
                  if (root.left == null) {
                        return root.right;
                  } else if (root.right == null) {
                        return root.left;
                  }
                  // Case 3: If the node to be deleted has two children, find the inorder
                  // successor
                  Node IS = findInorderSuccessor(root.right);
                  // Copy the inorder successor's data to the current node
                  root.data = IS.data;
                  // Delete the inorder successor
                  root.right = delete(root.right, IS.data);
            }
            return root;
      }

      // Method to find the inorder successor (smallest node in the right subtree)
      public static Node findInorderSuccessor(Node root) {
            // Traverse the left subtree until the leftmost node is found
            while (root.left != null) {
                  root = root.left;
            }
            // Return the leftmost node (inorder successor)
            return root;
      }

      // Main method to test the binary search tree operations
      public static void main(String[] args) {
            int values[] = { 8, 5, 1, 4, 6, 10, 11, 14 };
            Node root = null;
            // Insert values into the binary search tree
            for (int i = 0; i < values.length; i++) {
                  root = insert(root, values[i]);
            }
            // Perform in-order traversal and print the tree
            inOrder(root);
            System.out.println();
            // Delete a node with value 10
            root = delete(root, 10);
            // Perform in-order traversal and print the modified tree
            inOrder(root);
      }
}