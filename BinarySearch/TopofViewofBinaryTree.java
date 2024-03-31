package BinarySearch;

import java.util.*;

public class TopofViewofBinaryTree {
     // Nested class representing a node of a binary tree
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

     // Nested class to hold information about a node and its horizontal distance
     static class Info {
          Node node;
          int hd;

          // Constructor to initialize Info object with given node and horizontal distance
          public Info(Node node, int hd) {
               this.node = node;
               this.hd = hd;
          }
     }

     // Method to print the top view of a binary tree
     public static void topView(Node root) {
          // Check if the root is null
          if (root == null) {
               // If root is null, there's nothing to print, so return
               return;
          }

          // Initialize a queue for level order traversal and a hashmap to store nodes at
          // each horizontal distance
          Queue<Info> q = new LinkedList<>();
          HashMap<Integer, Node> map = new HashMap<>();
          // Variables to keep track of the range of horizontal distances
          int min = 0, max = 0;

          // Add the root node with horizontal distance 0 to the queue
          q.add(new Info(root, 0));
          // Add a marker to indicate the end of each level
          q.add(null);

          // Perform level order traversal
          while (!q.isEmpty()) {
               // Remove the front element from the queue
               Info curr = q.remove();

               // If the current element is null, it indicates the end of a level
               if (curr == null) {
                    // If the queue is empty, break the loop
                    if (q.isEmpty()) {
                         break;
                    } else {
                         // Add another null marker to indicate the end of the next level
                         q.add(null);
                    }
               } else {
                    // Process the current node
                    // If the horizontal distance of the current node is not in the map, add it
                    if (!map.containsKey(curr.hd)) {
                         // Store the current node with its horizontal distance in the map
                         map.put(curr.hd, curr.node);
                    }

                    // Explore the left child of the current node
                    if (curr.node.left != null) {
                         // Add the left child to the queue with horizontal distance decremented by 1
                         q.add(new Info(curr.node.left, curr.hd - 1));
                         // Update min if necessary
                         min = Math.min(min, curr.hd - 1);
                    }
                    // Explore the right child of the current node
                    if (curr.node.right != null) {
                         // Add the right child to the queue with horizontal distance incremented by 1
                         q.add(new Info(curr.node.right, curr.hd + 1));
                         // Update max if necessary
                         max = Math.max(max, curr.hd + 1);
                    }
               }
          }

          // Print the top view by iterating over horizontal distances from min to max-1
          for (int i = min; i < max; i++) {
               // Print the data of the node at the current horizontal distance
               System.out.print(map.get(i).data + " ");
          }
          // Print a new line after printing the top view
          System.out.println();
     }

     // Main method to test the topView method
     public static void main(String[] args) {
          // Create a binary tree
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);

          // Call the topView method to print the top view of the binary tree
          topView(root);
     }
}
