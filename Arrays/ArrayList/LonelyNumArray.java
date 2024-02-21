import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumArray {
    public static ArrayList<Integer> lonelyNumAppear(ArrayList<Integer> num) {

        // First, sort the array to facilitate number management.
        Collections.sort(num);

        // Next, create a new ArrayList to store the lonely numbers.
        ArrayList<Integer> lonelyNum = new ArrayList<Integer>();

        // Iterate through the original array to find the lonely numbers.
        for (int i = 1; i < num.size() - 1; i++) {
            // Check if the current number is not adjacent to its neighbors.
            if (num.get(i - 1) + 1 < num.get(i) && num.get(i) + 1 < num.get(i + 1)) {
                lonelyNum.add(num.get(i));
            }
        }

        // Handle the case when the array has only one element.
        if (num.size() == 1) {
            lonelyNum.add(num.get(0));
        }

        // Compare all elements with their adjacent neighbors. If they are not adjacent, add them.
        if (num.size() > 1) {
            // Check if the first element is a lonely number.
            if (num.get(0) + 1 < num.get(1)) {
                lonelyNum.add(num.get(0));
            }
             // Check if the last elements is a lonely number. 
            if (num.get(num.size() - 2) + 1 < num.get(num.size() - 1)) {
                lonelyNum.add(num.get(num.size() - 1));
            }
        }

        // Return the ArrayList containing the lonely numbers.
        return lonelyNum;
    }

    public static void main(String[] args) {
        // Create an ArrayList of integers and add some values to it.
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(10);
        num.add(6);
        num.add(5);
        num.add(8);

        // Call the 'lonelyNumAppear' method and print the result.
        System.out.println(lonelyNumAppear(num));
    }
}
