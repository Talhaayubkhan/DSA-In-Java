public class SumOfRow {
    public static int SumNumbers(int nums[][]) {
        // calculate 2nd row
        int sum = 0;
        for (int j = 0; j < nums[0].length; j++) {
            sum += nums[1][j];
        }
        // calculate 2nd column
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i][1];
        }

        return sum;

    }

    public static void main(String[] args) {
        int nums[][] = { { 1, 4, 9 },
                { 11, 4, 3 },
                { 2, 2, 3 } };
        int sum = SumNumbers(nums);
        System.out.println("Sum of rows: " + sum);
    }
}
