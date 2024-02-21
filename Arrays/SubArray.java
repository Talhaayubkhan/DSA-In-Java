public class SubArray {

     public static int printSubArray(int arr[]) {
          int n = arr.length;
          int max = Integer.MIN_VALUE;
          for (int i = 0; i < n; i++) {
               int sum = 0;
               for (int j = i; j < n; j++) {
                    sum += arr[j];
                    max = Math.max(max, sum);
               }
          }
          return max;
     }

     // optimal using kadane's algorithm

     public static int subArrayPrint(int arr[]) {
          int max = Integer.MIN_VALUE;
          int sum = 0;
          int n = arr.length;

          for (int i = 0; i < n; i++) {
               sum += arr[i];

               if (sum > max) {
                    max = sum;
               }

               if (sum < 0) {
                    sum = 0;
               }
          }
          //if array is empty
          if(max<0) max = 0;

          return max;
     }

     public static void main(String[] args) {
          int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
          // int maxSum = printSubArray(arr);
          int sumMax = subArrayPrint(arr);
          System.out.println(sumMax);

     }
}
