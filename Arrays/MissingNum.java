import java.util.*;
public class MissingNum {
    public static int findMissingNum(int arr[], int n){

        for(int i=1; i<n; i++){
            int ans =0;
            for(int j=0; j<n-1; j++){
                if(arr[j] == i){
                    ans = 1;
                    break;
                }
            }
            if(ans == 0){
                return i;
            }
        }
        return -1;
    }

    // using optimal Solution 1
    public static int missingNumber(int arr[], int n){

        int sum = (n * (n+1)) / 2;
        int S2 = 0;

        for(int i=0; i<n-1; i++){
            S2 += arr[i];
        }
    return (sum - S2);        
    }   

    // using second optimal solution this is a little better from sum 
    public static int numMissing(int a[], int N){

        int xor1=0; 
        int xor2=0;

        for(int i=0; i<N-1; i++){
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ N;

        return( xor1 ^ xor2);
    }
    public static void main(String[] args) {
        int N = 5;
        int a[] = {1, 2, 4, 5};
        // int n = arr.length + 1;
        // int missingNum = findMissingNum(arr, n);
        // int missing = missingNumber(arr, n);
        int missingNumber = numMissing(a, N);
        System.out.println("Missing Number is " + missingNumber);
    }
}
