public class LargestElemet {
    public static int LargestNum(int arr[]) {

        // declare largest element
        // find smallest and largest element
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        System.out.println("Smallest value is " + smallest);
        return largest;

    }

    // seconLargestElement
    public static int seconLargestElement(int arr[]) {
        int largest = 0;
        int sLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] <= largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    // find secondsmallest element
    public static int secondsmallest(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        int sSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                sSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < sSmallest) {
                sSmallest = arr[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 2, 4 };
        System.out.println("Second Smallest Element " + secondsmallest(arr));
        System.out.println("Second largest Element " + seconLargestElement(arr));
        System.out.println("Largest Element is = " + LargestNum(arr));
    }
}
