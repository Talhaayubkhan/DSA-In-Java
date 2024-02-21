import java.util.*;

public class InterLeaveNum {
     public static void interleave(Queue<Integer> q){

          // Step 1: Create a new queue to store the first half of the original queue
          Queue<Integer> firstHalf = new LinkedList<>();

          // Step 2: Get the size of the original queue
          int size = q.size();

          // Step 3: Move the first half of the original queue to the 'firstHalf' queue
          for(int i = 0; i < size / 2; i++){
               firstHalf.add(q.remove());
          }

          // Step 4: Interleave elements from 'firstHalf' and the remaining elements in the original queue
          while (!firstHalf.isEmpty()) {
               // Step 4.1: Add an element from 'firstHalf' to the original queue
               q.add(firstHalf.remove());
               // Step 4.2: Add the corresponding element from the original queue to maintain interleaving
               q.add(q.remove());
          }
     }

     public static void main(String[] args) {
          // Step 5: Create a queue and add elements to it
          Queue<Integer> q = new LinkedList<Integer>();
          q.add(1);
          q.add(2);
          q.add(3);
          q.add(4);
          q.add(5);
          q.add(6);
          q.add(7);
          q.add(8);
          q.add(9);
          q.add(10);

          // Step 6: Call the 'interleave' method to perform interleaving
          interleave(q);

          // Step 7: Print the interleaved queue
          while (!q.isEmpty()) {
               System.out.println(q.remove() + " ");
          }
          System.out.println();
     }
}
