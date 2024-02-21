public class MergSort {
    public static void mergSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // find mid
        int mid = si + (ei - si) / 2;
        mergSort(arr, si, mid);
        mergSort(arr, mid + 1, ei);
        mergeboth(arr, si, mid, ei);
    }

    public static void mergeboth(int arr[], int si, int mid, int ei) {
        // create temp arr
        int temp[] = new int[ei - si + 1];
        // left iterator
        int i = si;
        // right iterator
        int j = mid + 1;

        // create iterator for temp array
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // create another while loop to store remaning element
        // for left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for right part

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // store these sorted elements from temp to original array
        // we create for loop

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
