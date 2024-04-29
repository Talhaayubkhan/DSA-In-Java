public class MirrorBinarySearchTree { // Main class for mirroring a binary search tree
      // Inner class representing a node in a binary search tree
      static class Node {
            int data; // Data stored in the node
            Node left; // Reference to the left child node
            Node right; // Reference to the right child node

            // Constructor to initialize a node with given data
            Node(int data) {
                  this.data = data; // Set node data
                  this.left = null; // Initialize left child as null
                  this.right = null; // Initialize right child as null
            }
      }

      // Function to mirror a binary search tree
      public static Node mirrorGeneratedBST(Node root) {
            // If the current node is null, return null (base case for recursion)
            if (root == null) {
                  return null;
            }

            // Recursively mirror the left subtree and store it in `leftSubTreeMirror`
            Node leftSubTreeMirror = mirrorGeneratedBST(root.left);
            // Recursively mirror the right subtree and store it in `rightSubTreeMirror`
            Node rightSubTreeMirror = mirrorGeneratedBST(root.right);

            // Swap the left and right children to create the mirrored structure
            root.left = rightSubTreeMirror;
            root.right = leftSubTreeMirror;

            // Return the current node (with its children mirrored)
            return root;
      }

      // Function for pre-order traversal of a binary search tree
      public static void preorder(Node root) {
            // If the current node is null, return without any action
            if (root == null) {
                  return;
            }
            // Print the data of the current node
            System.out.print(root.data + " ");
            // Recursively traverse the left subtree in pre-order
            preorder(root.left);
            // Recursively traverse the right subtree in pre-order
            preorder(root.right);
      }

      // Main method to execute the program
      public static void main(String[] args) {
            // Create a binary search tree with a root node of 8
            Node root = new Node(8);
            // Add additional nodes to form the tree structure
            root.left = new Node(5); // Set the left child of root to 5
            root.right = new Node(10); // Set the right child of root to 10
            root.left.left = new Node(3); // Set the left child of node 5 to 3
            root.left.right = new Node(6); // Set the right child of node 5 to 6
            root.right.right = new Node(11); // Set the right child of node 10 to 11

            // Mirror the binary search tree
            root = mirrorGeneratedBST(root);
            // Perform pre-order traversal on the mirrored tree
            preorder(root);
      }
}
