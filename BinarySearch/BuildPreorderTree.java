package BinarySearch;

import java.util.*;

// Define a class to create a binary tree from a given array
public class BuildPreorderTree {

     // Define a structure to represent individual nodes in the binary tree
     static class Node {
          int data; // value of the node
          Node left; // reference to the left child
          Node right; // reference to the right child

          // Constructor to create a node with the given value
          Node(int data) {
               this.data = data; // assign the given value
               this.left = null; // initialize left child as null
               this.right = null; // initialize right child as null
          }
     }

     // Define a structure to manage the construction of the binary tree
     static class BinaryTree {

          // Variable to track the current position in the array during tree construction
          static int idx = -1;

          // Method to build the binary tree recursively from a given array
          public static Node buildTree(int nodes[]) {
               idx++; // move to the next element in the array

               // If the current element is -1, it indicates a null node, so return null
               if (nodes[idx] == -1) {
                    return null;
               }

               // Create a new node with the current element's value
               Node newNode = new Node(nodes[idx]);

               // Recursively build the left and right subtrees of the current node
               newNode.left = buildTree(nodes);
               newNode.right = buildTree(nodes);

               // Return the newly created node
               return newNode;
          }

          // Method to perform preorder traversal of the binary tree
          public static void preorder(Node root) {
               // Base case: If the root is null, return
               if (root == null) {
                    System.out.print("-1, "); // Print -1 to indicate a null node
                    return;
               }

               // Print the data of the current node before traversing its children
               System.out.print(root.data + " ");

               // Recursively traverse the left subtree
               preorder(root.left);

               // Recursively traverse the right subtree
               preorder(root.right);
          }

          // Method to perform inorder traversal of the binary tree
          public static void inorder(Node root) {
               // Base case: If the root is null, return
               if (root == null) {
                    return;
               }

               // Recursively traverse the left subtree
               inorder(root.left);

               // Print the data of the current node in between traversing its left and right
               // children
               System.out.print(root.data + " ");

               // Recursively traverse the right subtree
               inorder(root.right);
          }

          // Method to perform postorder traversal of the binary tree
          public static void postorder(Node root) {
               // Base case: If the root is null, return
               if (root == null)
                    return;

               // Recursively traverse the left subtree
               postorder(root.left);

               // Recursively traverse the right subtree
               postorder(root.right);

               // Print the data of the current node after traversing its children
               System.out.print(root.data + " ");
          }

          // Method to perform level-order traversal of the binary tree
          public static void levelOrder(Node root) {

               // If the root is null, return
               if (root == null) {
                    return;
               }

               // Create a queue to store nodes to be processed
               Queue<Node> q = new LinkedList<>();
               // Enqueue the root node to start traversal
               q.add(root);
               // Enqueue a marker (null) to indicate the end of each level
               q.add(null);

               // Loop until the queue is empty
               while (!q.isEmpty()) {
                    // Dequeue the current node
                    Node currNode = q.remove();

                    // Check if the current node is a marker (end of level)
                    if (currNode == null) {
                         // Print a newline to start a new level
                         System.out.println();
                         // If the queue is empty, break out of the loop
                         if (q.isEmpty()) {
                              break;
                         } else {
                              // Enqueue another marker to indicate the end of the next level
                              q.add(null);
                         }
                    } else {
                         // Print the data of the current node
                         System.out.print(currNode.data + " ");

                         // Enqueue the left child if it exists
                         if (currNode.left != null) {
                              q.add(currNode.left);
                         }
                         // Enqueue the right child if it exists
                         if (currNode.right != null) {
                              q.add(currNode.right);
                         }
                    }
               }
          }
     }

     // Main method to demonstrate the construction of the binary tree
     public static void main(String[] args) {
          // Preorder traversal array representing the binary tree structure
          int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

          // Create an instance of the BinaryTree class
          BinaryTree tree = new BinaryTree();

          // Build the binary tree from the preorder traversal array
          Node root = tree.buildTree(nodes);

          // Perform level-order traversal and print the nodes
          tree.levelOrder(root);
     }
}
