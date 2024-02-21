public class RemoveDuplicate {
    public static int duplicateRemove(int arr[]) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 6, 6, 10, 10, 10 };
        System.out.println("Num of Unique Elements is = " + duplicateRemove(arr));
    }
}
