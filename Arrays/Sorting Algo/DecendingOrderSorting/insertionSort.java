package DecendingOrderSorting;

public class insertionSort {

    public static void insertionSortDecending(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int prev = i;
            while (prev > 0 && arr[prev - 1] < arr[prev]) {
                int temp = arr[prev - 1];
                arr[prev - 1] = arr[prev];
                arr[prev] = temp;
                prev--;
            }
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        insertionSortDecending(arr);
        printArr(arr);
    }
}
