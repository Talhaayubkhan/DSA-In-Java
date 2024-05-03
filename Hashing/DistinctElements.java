package Hashing;

import java.util.*;

public class DistinctElements {
      public static void isUniqueElements(int nums[]) {

            HashSet<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < nums.length; i++) {
                  set.add(nums[i]);
            }
            System.out.println("ans is = " + set.size());
      }

      public static void main(String[] args) {
            int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
            isUniqueElements(nums);
      }
}
