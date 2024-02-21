import java.util.*;

public class FrequentNum {

    public static int frequentNum(ArrayList<Integer> num, int key) {
        // Create an array to store the frequency of numbers that appear after the 'key.'
        int[] result = new int[1000];

        // Iterate through the 'num' ArrayList to count the frequencies.
        for (int i = 0; i < num.size() - 1; i++) {
            // Check if the current element matches the 'key.'
            if (num.get(i) == key) {
                // Increment the count for the number that appears after 'key' in 'result.'
                result[num.get(i + 1) - 1]++;
            }
        }

        // Initialize 'max' with the minimum possible value.
        int max = Integer.MIN_VALUE;
        int ans = 0;

        // Find the number with the highest frequency (the most frequent number).
        for (int i = 0; i < 1000; i++) {
            // Check if the frequency of the number at index 'i' in 'result' is greater than 'max.'
            if (result[i] > max) {
                // Update 'max' with the new maximum frequency and 'ans' with the corresponding number.
                max = result[i];
                ans = i + 1; // Adding 1 because the index is 0-based, but numbers start at 1.
            }
        }

        return ans; // Return the most frequent number.
    }

    public static void main(String[] args) {
        // Create an ArrayList of integers and add values to it.
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(100);
        num.add(200);
        num.add(1);
        num.add(100);

        int key = 1; // Specify the key.
        System.out.println(frequentNum(num, key)); // Call the method and print the result.
    }
}
