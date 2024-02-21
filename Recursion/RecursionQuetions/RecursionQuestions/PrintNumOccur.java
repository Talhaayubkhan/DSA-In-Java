package RecursionQuetions.RecursionQuestions;

public class PrintNumOccur {
    public static void numOccurrences(int arr[], int key, int i) {

        // base case

        if (i == arr.length) {
            return;
        }

        // print them (Point)
        if (arr[i] == key) {
            System.out.print(i + " ");
        }

        numOccurrences(arr, key, i + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2, 3, 6, 7, 7, 6, 3 };
        int key = 7;
        numOccurrences(arr, key, 0);
    }
}
