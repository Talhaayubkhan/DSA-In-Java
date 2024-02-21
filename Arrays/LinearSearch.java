public class LinearSearch {
    // for numbers
    // public static int linearSearch(int arr[], int key) {
    // // simple linear Search algorithm
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] == key) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // for String
    public static int searchLinear(String arr[], String key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        String arr[] = { "Apple", "Pears", "Orange", "Banana" };
        String key = "Orange";
        System.out.println("Found at " + searchLinear(arr, key));
        // int key = 14;
        // System.out.println(linearSearch(arr, key));
    }
}
