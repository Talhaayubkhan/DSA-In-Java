public class QuickSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pIndx = partition(arr, si, ei);
        quickSort(arr, si, pIndx - 1);
        quickSort(arr, pIndx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pIndx = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] < pIndx) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pIndx;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 2, 5, 7, 9, 1, 3 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
