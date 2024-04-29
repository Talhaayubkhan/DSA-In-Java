public class ValidBinarySearchTree {
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

      public static boolean isValidBST(Node root, Node min, Node max) {
            // If the root is null, it means this subtree is empty or we've reached the end
            // of a branch.
            // An empty subtree is always a valid BST.
            if (root == null) {
                  return true; // Returning true because an empty tree does not violate BST rules.
            }

            // Check if the current node's data is less than or equal to the minimum allowed
            // value (min).
            // If it is, it means the BST property is violated because this node should be
            // greater than min.
            if (min != null && root.data <= min.data) {
                  return false; // Return false because this violates the BST property.
            }

            // Check if the current node's data is greater than or equal to the maximum
            // allowed value (max).
            // If it is, it means the BST property is violated because this node should be
            // smaller than max.
            else if (max != null && root.data >= max.data) {
                  return false; // Return false because this violates the BST property.
            }

            // Recursively check the left subtree, updating the maximum boundary to the
            // current node.
            // This ensures all nodes in the left subtree are strictly smaller than the
            // current node.
            boolean isLeftBST = isValidBST(root.left, min, root);

            // Recursively check the right subtree, updating the minimum boundary to the
            // current node.
            // This ensures all nodes in the right subtree are strictly greater than the
            // current node.
            boolean isRightBST = isValidBST(root.right, root, max);

            // The subtree rooted at 'root' is a valid BST only if both the left and right
            // subtrees are valid BSTs.
            return isLeftBST && isRightBST;
      }

      public static void main(String[] args) {
            int values[] = { 8, 5, 3, 6, 10, 11, 14 };
            Node root = null;
            for (int i = 0; i < values.length; i++) {
                  root = insert(root, values[i]);
            }

            inOrder(root);
            System.out.println();

            if (isValidBST(root, null, null)) {
                  System.out.println("valid");
            } else {
                  System.out.println("not valid");
            }
      }
}
