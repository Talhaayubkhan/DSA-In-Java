public class MajorityElement {
     public static int getMajorityElement(int n, int arr[]) {
          // brute force Approach
          for (int i = 0; i < n; i++) {
               int count = 0;

               for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j]) {
                         count++;
                    }
               }
               if (count > n / 2) {
                    return arr[i];
               }
          }
          return -1;
     }

     // use optimal Approach
     public static int majorityElement(int arr[]) {
          int n = arr.length;
          int count = 0;
          int el = 0;

          for (int i = 0; i < n; i++) {

               if (count == 0) {
                    count = 1;
                    el = arr[i];
               } else if (el == arr[i]) {
                    count++;
               } else {
                    count--;
               }

          }

          // what if array is sorted element is majority element

          int count1 = 0;

          for (int i = 0; i < n; i++) {
               if (arr[i] == el) {
                    count1++;
               }
          }

          if (count1 > (n / 2)) {
               return el;
          }

          return -1;
     }

     public static void main(String[] args) {
          // int n=7;
          // int arr[] = { 3, 3, 3, 3, 1, 2, 2 };
          int arr[] = { 7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

          // System.out.println(getMajorityElement(n, arr));
          System.out.print(majorityElement(arr));

     }
}
