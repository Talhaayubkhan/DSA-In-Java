package PracticeQuestion;

// import java.util.ArrayList;
public class LargestOddNumberInRange {
     public static int largestOddNumberInRange(int[] range, int k) {
          if (k <= 0) {
               return 0;
          }

          int L = range[0];
          int R = range[1];

          if ((R & 1) > 0) {
               int count = (int) Math.ceil((R - L + 1) / 2);
               if (k > count)
                    return 0;
               else
                    return (R - 2 * k + 2);
          } else {
               int count = (R - L + 1) / 2;
               if (k > count)
                    return 0;
               else
                    return (R - 2 * k + 1);
          }
     }

     public static void main(String[] args) {
          int[] range = { -3, 3 };
          int k = 1;

          int largestOdd = largestOddNumberInRange(range, k);
          System.out.println("Kth largest odd number in the range: " + largestOdd);
     }
}
