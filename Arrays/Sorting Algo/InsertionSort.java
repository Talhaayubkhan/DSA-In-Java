import java.util.*;

public class InsertionSort {
    public static void insertionSort(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int prev = i;
            while (prev > 0 && nums[prev - 1] > nums[prev]) {
                // swap
                int temp = nums[prev - 1];
                nums[prev - 1] = nums[prev];
                nums[prev] = temp;
                prev--;
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
        int nums[] = { 1, 2, 5, 3, 4 };
        // insertionSort(nums);
        Arrays.sort(nums, 0, 4);
        PrintArray(nums);
    }
}
