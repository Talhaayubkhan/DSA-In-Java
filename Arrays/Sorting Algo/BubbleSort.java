public class BubbleSort {
    public static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) {
                break;
            }
        }

    }

    public static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        bubbleSort(arr);
        PrintArray(arr);
    }
}
