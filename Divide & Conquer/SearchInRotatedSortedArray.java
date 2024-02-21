public class SearchInRotatedSortedArray {
    public static int search(int arr[], int tar, int si, int ei) {

        // using recursion
        // base case
        if (si > ei) {
            return -1;
        }

        // find mid
        int mid = si + (ei - si) / 2;

        // if found on mid
        if (arr[mid] == tar) {
            return mid;
        }

        //

        // mid on L2
        if (arr[si] <= arr[mid]) {

            // left part
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                // for right part
                return search(arr, tar, mid + 1, ei);
            }
        }
        // mid on L2

        else {
            // for right part
            if (arr[mid] < tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, arr[ei]);
            } else {
                // for left part
                return search(arr, tar, arr[si], mid - 1);
            }
        }
    }

    public static boolean printElement(int arr[], int target) {

        // using single loop
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.print("found at: " + i + " ");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;
        // int tarIdx = search(arr, target, 0, arr.length - 1);
        // System.out.println("Found at " + tarIdx);
        System.out.println(printElement(arr, target));
    }
}
