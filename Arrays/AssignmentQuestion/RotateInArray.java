package AssignmentQuestion;

public class RotateInArray {
    public static int Rotate(int nums[], int d, int target) {
        d = d % nums.length;

        // merge in temp those who rotate
        int temp[] = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = nums[i];
        }

        for (int i = d; i < nums.length; i++) {
            nums[i - d] = nums[i];
        }

        // print temp
        for (int i = nums.length - d; i < nums.length; i++) {
            nums[i] = temp[i - (nums.length - d)];
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 2, 3, 4, 5, 6 };
        int target = 0;
        int targetIndex = Rotate(nums, 4, target);
        printArray(nums);
        System.out.println("Target index is " + targetIndex);
    }
}
