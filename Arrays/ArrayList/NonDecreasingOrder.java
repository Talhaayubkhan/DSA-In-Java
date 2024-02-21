import java.util.*;

public class NonDecreasingOrder {
    public static boolean isNonDecreasing(ArrayList<Integer> list){
       
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) <= list.get(i+1)){
                return true;
            }
        }

        return false;

       
    }
    public static boolean isNonIncreasing(ArrayList<Integer> list){
       
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)){
                return true;
            }
        }

        return false;



// this combination of both non-increasing and non-decreasing
    //     boolean inc=true;
    //     boolean dec=true;

    //     for(int i=0;i<list.size()-1;i++) {

    //     if(list.get(i) > list.get(i+1)){
    //         inc=false;
    //     }
    //        else if(list.get(i) < list.get(i+1)){
    //         dec=false;
    //     }
    // }
    //         return inc||dec;
    }

    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        // list.add(8);
        list.add(8);
        list.add(7);

        // System.out.println(isNonDecreasing(list));
        System.out.println(isNonIncreasing(list));
    }
}
