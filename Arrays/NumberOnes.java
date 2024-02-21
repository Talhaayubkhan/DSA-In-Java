import java.util.*;
public class NumberOnes {
    public static int appearOnes(int arr[]){

        for(int i=0; i<arr.length-1; i++){
            int num = arr[i];
            int count = 0;
            for(int j=0; j<arr.length-1; j++){
                if(arr[j] == num){
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return -1;
        
    }

    // optimal solution
    public static int OnesAppear(int arr[]){
        int xor=0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        // int n= 7;
        int arr[]= {4,1,2,1,4};
        // System.out.println(appearOnes(arr));
        int ans = OnesAppear(arr);
        System.out.println("The single element is " + ans);
    }
}

