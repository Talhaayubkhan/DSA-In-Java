import java.util.*;
public class TwoSum {

     public static String twoSum(int arr[], int n, int target){

          HashMap<Integer, Integer> ans = new HashMap<>();

          for(int i=0; i<n; i++){
               int num = arr[i];
               int moreNum = target - num;

               if(ans.containsKey(moreNum) ){
                    return "YES";
               }
               ans.put(arr[i], i);
          }

          return "NO";
     }

     // Optimal Approach 

     public static String sumTwoOptimize(int arr[], int n, int target){

          Arrays.sort(arr);

          int left =0; int right =n-1;

          while (left < right) {
               
               int sum = arr[left] + arr[right];
               if(sum == target){
                    return "YES";
               }
               else if( sum < target){
                    left++;
               }else{
                    right--;
               }
          }
          return "NO";
     }
     public static void main(String[] args) {
          int n =5;

          int arr[] = {2,6,5,8,11};
          int target = 13;

          // String getSum = twoSum(arr, n, target);
          String ans = sumTwoOptimize(arr, n, target);
          // System.out.println("The Answer is " + getSum);
          System.out.println("The Answer is " + ans);

     }
}
