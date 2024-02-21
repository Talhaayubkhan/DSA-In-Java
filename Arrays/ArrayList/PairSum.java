import java.util.*;

public class PairSum {

    // brute Force Approach
    // O(n^2)
    public static boolean possiblePairSum(ArrayList<Integer> list , int target){

        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){

                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // Optimal Approach 
    // O(n)

    public static boolean pairSumOptimized(ArrayList<Integer> list, int target){

        int lp =0; 
        int rp = list.size()-1;

        while(lp != rp){
            // case 1:
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target){
                lp++;
            }else{
                rp--;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        int target = 9;
        // System.out.println(possiblePairSum(list, target));
        System.out.println(pairSumOptimized(list, target));
    
    }
}
