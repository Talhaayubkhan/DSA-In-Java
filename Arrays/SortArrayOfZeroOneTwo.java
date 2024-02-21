import java.util.*;

public class SortArrayOfZeroOneTwo {
     public static void sortAnArray(ArrayList<Integer> list, int n) {
          int low = 0;
          int mid = 0;
          int high = n - 1;

          while (mid <= high) {
               if (list.get(mid) == 0) {
                    // swap low and mid
                    int temp = list.get(mid);
                    list.set(mid, list.get(low));
                    list.set(low, temp);

                    low++;
                    mid++;
               } else if (list.get(mid) == 1) {
                    mid++;
               } else if (list.get(mid) == 2) {
                    // again swap mid and high
                    int temp = list.get(mid);
                    list.set(mid, list.get(high));
                    list.set(high, temp);

                    high--;
               }
          }
     }

     public static void main(String[] args) {
          int n = 11;
          ArrayList<Integer> list = new ArrayList<Integer>();
          list.add(0);
          list.add(1);
          list.add(1);
          list.add(0);
          list.add(1);
          list.add(2);
          list.add(1);
          list.add(2);
          list.add(0);
          list.add(0);
          list.add(0);

          sortAnArray(list, n);
          System.out.print("After Sorting ");
          for (int i = 0; i < n; i++) {
               System.out.print(list.get(i) + " ");
          }
          System.out.println();
     }
}
