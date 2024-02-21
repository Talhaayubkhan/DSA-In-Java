public class ArraySort {
    public static boolean isSorted(int arr[]) {
        // int num = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 200, 30, 4, 5 };
        System.out.println(isSorted(arr));
    }
}
