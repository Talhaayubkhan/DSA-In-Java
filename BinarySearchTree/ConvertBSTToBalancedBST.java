import java.util.ArrayList;

public class ConvertBSTToBalancedBST {
      static class Node {
            int data; // The value/data stored in the node
            Node left; // Left child reference
            Node right; // Right child reference

            // Constructor to initialize a node with a given data value
            Node(int data) {
                  this.data = data; // Set the node's data to the given value
            }
      }

      // Function to perform a preorder traversal of the binary tree
      public static void preorder(Node root) {
            // If the current node is null, return (base case)
            if (root == null)
                  return; // End the recursion if node is null

            System.out.print(root.data + " "); // Print the node's data
            // Recursively traverse the left subtree
            preorder(root.left);
            // Recursively traverse the right subtree
            preorder(root.right);
      }

      // Function to get the inorder traversal of a binary tree and store it in an
      // ArrayList
      public static void getInorder(Node root, ArrayList<Integer> inorder) {
            // If the current node is null, return (base case)
            if (root == null)
                  return; // End the recursion if node is null

            // Recursively traverse the left subtree to get left nodes
            getInorder(root.left, inorder);

            // Add current node's data to the inorder list
            inorder.add(root.data);

            // Recursively traverse the right subtree to get right nodes
            getInorder(root.right, inorder);
      }

      // Function to create a balanced BST from a sorted list of integers
      public static Node createSortedBST(ArrayList<Integer> inorder, int start, int end) {
            // If start index is greater than end index, there are no nodes to create
            if (start > end)
                  return null; // End the recursion if there are no more nodes

            // Find the midpoint to use as the root node
            int mid = (start + end) / 2;

            // Create a new node with the value at the midpoint
            Node root = new Node(inorder.get(mid));

            // Recursively create the left subtree from the left half of the list
            root.left = createSortedBST(inorder, start, mid - 1);

            // Recursively create the right subtree from the right half of the list
            root.right = createSortedBST(inorder, mid + 1, end);

            return root; // Return the newly created node
      }

      // Function to balance an unbalanced BST by obtaining its inorder traversal and
      // creating a new balanced BST
      public static Node balanceBST(Node root) {
            ArrayList<Integer> inorder = new ArrayList<>(); // Create a list to store the inorder traversal

            // Obtain the inorder traversal of the original unbalanced BST
            getInorder(root, inorder);

            // Create a new balanced BST using the inorder traversal
            root = createSortedBST(inorder, 0, inorder.size() - 1);

            return root; // Return the balanced BST
      }

      public static void main(String[] args) {
            // Create an unbalanced BST with some nodes
            Node root = new Node(8);
            root.left = new Node(6);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);

            root.right = new Node(10);
            root.right.right = new Node(11);
            root.right.right.right = new Node(12);

            // Balance the unbalanced BST
            root = balanceBST(root);

            // Perform a preorder traversal of the balanced BST
            preorder(root); // Expected output: 8 5 3 6 11 10 12
      }
}
