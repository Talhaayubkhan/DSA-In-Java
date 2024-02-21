import java.util.ArrayList;

public class Swap {
    public static void swap(ArrayList<Integer> list, int idx, int idx2){
        int temp = list.get(idx);
        list.set(idx, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(2);
        list.add(9);
        list.add(6);
        list.add(3);
        
        int idx = 1, idx2 =4;
        System.out.println(list);
        swap(list, idx, idx2);
        System.out.println(list);
    }
}
