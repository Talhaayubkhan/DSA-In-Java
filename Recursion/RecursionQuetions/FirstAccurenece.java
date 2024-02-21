package RecursionQuetions;

public class FirstAccurenece {

    // find first Accurenece Index
    public static int firstAcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }

        return firstAcc(arr, key, i + 1);
    }

    // find last Accurenece Index
    public static int LastAcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = LastAcc(arr, key, i + 1);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // find first and last occurences of num
    // we declare first and last as static so the value of first and last are
    // constant
    public static int first = -1;
    public static int last = -1;

    public static void findOccurence(String str, int idx, char element) {

        // base case
        if (idx == str.length()) {
            System.out.println(first);
            System.out.println(last);
        }
        char currElement = str.charAt(idx);

        if (currElement == element) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }

        findOccurence(str, idx + 1, element);
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 5, 5, 5 };
        String str = "ddsawwqrtyvdasddwwad";
        findOccurence(str, 0, 'w');
        // System.out.println(firstAcc(arr, 5, 0));
        // System.out.println(LastAcc(arr, 5, 0));
    }
}
