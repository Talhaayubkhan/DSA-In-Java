public class RotateArrayByOne {
    public static void rotateByOne(int arr[], int n) {
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // left rotate Array by d elements
    // brut force approach
    public static void leftRotate(int arr[], int d) {
        d = d % arr.length;

        if (d == 0)
            return;

        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        for (int i = arr.length - d; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - d)];
        }
    }

    // optimal solution
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    public static void leftRotate1(int arr[], int d, int n) {
        d = d % n;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    // left rotation by d places
    public static void rightRotate(int arr[], int d) {
        d = d % arr.length;

        int temp[] = new int[d];

        for (int i = arr.length - d; i < arr.length; i++) {
            temp[i - (arr.length - d)] = arr[i];
        }

        for (int i = arr.length - d - 1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }

    }

    // now optimal solution
    public static void reverseRightRotation(int arr[], int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void optimalRightRotation(int arr[], int d) {

        d = d % arr.length;

        reverseRightRotation(arr, arr.length - d, arr.length - 1);
        reverseRightRotation(arr, 0, arr.length - d - 1);
        reverseRightRotation(arr, 0, arr.length - 1);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // rotateByOne(arr, 5);
        // reverseInLeftRotation(arr, 0, 3 );
        System.out.println("Before rotation:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        // leftRotate(arr, n);
        // rightRotate(arr, 3);
        optimalRightRotation(arr, 3);
        printArray(arr);
    }
}
