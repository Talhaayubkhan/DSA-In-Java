public class PutZeroInLast {
    public static void ZeroInLast(int arr[]) {

        // brute force approach
        int temp[] = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[k] = arr[i];
                k++;
            }
        }

        k = temp.length;
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

        for (int i = k; i < arr.length; i++) {
            temp[k] = 0;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // optimal solution
    public static void ZeroToEnd(int arr[]) {
        int j = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        // ZeroInLast(arr);
        System.out.println("Before rotation:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        ZeroToEnd(arr);
        printArray(arr);
    }
}
