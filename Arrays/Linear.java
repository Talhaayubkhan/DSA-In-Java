public class Linear {
    public static int linearSearch(int arr[], int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 10, 3, 4, 5, 6 };
        int num = 3;
        System.out.println("Found at = " + linearSearch(arr, num));
    }
}
