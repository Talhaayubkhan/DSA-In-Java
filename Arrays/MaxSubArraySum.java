import java.util.*;

public class MaxSubArraySum {

      public static int maxSubArraySum(int arr[]) {
            int n = arr.length;
            int maxSubArray = Integer.MIN_VALUE;
            int currSum = 0;

            for (int i = 0; i < n; i++) {
                  currSum += arr[i];

                  if (currSum > maxSubArray) {
                        maxSubArray = currSum;
                  }

                  if (currSum < 0) {
                        currSum = 0;
                  }
            }

            return maxSubArray;
      }

      public static void main(String[] args) {
            int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
            int maxSum = maxSubArraySum(arr);
            System.out.println("Maximum contiguous sum is = " + maxSum);
      }
}
