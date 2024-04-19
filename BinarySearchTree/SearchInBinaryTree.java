public class SearchInBinaryTree {
      static class Node {
            int data;
            Node left, right;

            public Node(int data) {
                  this.data = data;
            }
      }

      public static Node binarySearch(Node root, int values) {
            if (root == null) {
                  root = new Node(values);
                  return root;
            }

            if (root.data > values) {
                  root.left = binarySearch(root.left, values);
            } else {
                  root.right = binarySearch(root.right, values);
            }
            return root;

      }

      public static void inOrder(Node root) {
            if (root == null) {
                  return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
      }

      public static boolean search(Node root, int key) {
            if (root == null) {
                  return false;
            }

            if (root.data == key) {
                  return true;
            }
            if (root.data > key) {
                  search(root.left, key);
            } else {
                  search(root.right, key);
            }

            return false;
      }

      public static void main(String[] args) {
            int values[] = { 5, 1, 3, 4, 2, 6, 7 };
            Node root = null;

            for (int i = 0; i < values.length; i++) {
                  root = binarySearch(root, values[i]);
            }

            inOrder(root);

            if (search(root, 8)) {
                  System.out.println("Found");
            } else {
                  System.out.println("Not Found");
            }

      }
}
