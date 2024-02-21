package Questions;

public class MergeSort {
    public static void sortString(String arr[], int si, int ei) {

        // base case
        if (si >= ei) {
            return;
        }

        // find mid
        int mid = si + (ei - si) / 2;

        // recursive call the main function
        sortString(arr, si, mid);
        sortString(arr, mid + 1, ei);

        // merge both string
        mergeSort(arr, si, mid, ei);

    }

    public static void mergeSort(String arr[], int si, int mid, int ei) {
        // create temp to store string
        String temp[] = new String[ei - si + 1];

        int i = si;
        int j = mid + 1;

        int k = 0;

        // to check first character form both string
        while (i <= mid && j <= ei) {
            // if given array both small and capital string so we use compareToIgnoreCase!
            if (arr[i].compareToIgnoreCase(arr[j]) <= 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for left part if some string are still in array
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        // for right part if some string are still in array

        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // finally all temp store in original array!
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void printArr(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "orange", "mango", "apple", "Zoo", "Banana" };
        sortString(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
