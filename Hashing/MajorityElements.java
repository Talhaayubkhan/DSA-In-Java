package Hashing;

import java.util.*;

public class MajorityElements {
      public static void printMajorityElement(int arr[]) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < arr.length; i++) {
                  // int nums = arr[i];
                  // if (map.containsKey(nums)) {
                  // map.put(arr[i], map.get(arr[i]) + 1);
                  // } else {
                  // map.put(arr[i], 1);
                  // }

                  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            for (Integer key : map.keySet()) {
                  if (map.get(key) > arr.length / 3) {
                        System.out.println(key + " ");
                  }
            }
      }

      public static void main(String[] args) {
            int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

            printMajorityElement(arr);
      }
}
