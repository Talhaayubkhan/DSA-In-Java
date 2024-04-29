public class PrintInRange {
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

      public static void printInRange(Node root, int low, int high) {
            // Base case: If the root is null, there is nothing to process, so return.
            if (root == null) {
                  return;
            }

            // If the current node's value is within the specified range,
            // recursively explore the left subtree, then print the current node's data,
            // and finally explore the right subtree.
            if (root.data >= low && root.data <= high) {
                  printInRange(root.left, low, high); // Recurse into the left subtree.
                  System.out.println(root.data + " "); // Print the current node's data.
                  printInRange(root.right, low, high); // Recurse into the right subtree.
            }
            // If the current node's value is less than the lower bound of the range,
            // skip the left subtree and recurse into the right subtree to find possible
            // valid nodes.
            else if (root.data < low) {
                  printInRange(root.right, low, high); // Recurse into the right subtree.
            }
            // If the current node's value is greater than the upper bound of the range,
            // skip the right subtree and recurse into the left subtree to find possible
            // valid nodes.
            else {
                  printInRange(root.left, low, high); // Recurse into the left subtree.
            }
      }

      public static void main(String[] args) {
            int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
            Node root = null;
            for (int i = 0; i < values.length; i++) {
                  root = insert(root, values[i]);
            }

            inOrder(root);
            System.out.println();

            printInRange(root, 5, 12);
      }
}
