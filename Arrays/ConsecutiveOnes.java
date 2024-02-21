public class ConsecutiveOnes{
    public static int foundOnes(int arr[]){
        // Optimal Approach to solve this
        
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == 1){
                count++;
                max = Math.max(max, count);
            }else{
                count=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
     int arr[] = {1,1,0,1,1,1,0,1,1};
    
     System.out.println("The Consecutive Ones are = " + foundOnes(arr));
        
    }
}