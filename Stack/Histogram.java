import java.util.*;
public class Histogram {
     public static void maxHistogramArea(int arr[]){
          
          int maxArea = 0;
          int nsr[] = new int[arr.length];
          int nsl[] = new int[arr.length];


          Stack<Integer> s = new Stack<Integer>();

          for(int i=arr.length-1; i>=0; i--){
               while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
               }

               if(s.isEmpty()) {
                    nsr[i] = arr.length;
               }
               else {
                    nsr[i] = s.peek();
               }

               s.push(i);
          }
          
          
          s = new Stack<Integer>();

          for(int i=0; i<arr.length; i++){
               while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
               }

               if(s.isEmpty()) {
                    nsl[i] = -1;
               }
               else {
                    nsl[i] = s.peek();
               }

               s.push(i);
          }

          // 
          for(int i=0; i<arr.length; i++) {
               int height = arr[i];
               int width = nsr[i] - nsl[i] - 1;
               int currArea = height * width;
               maxArea = Math.max(maxArea, currArea);

          }

          System.out.println("Max Area in Histogram is: " + maxArea);
     }
     public static void main(String[] args) {
          int arr[] = {2,4 };
          maxHistogramArea(arr);
     }
}
