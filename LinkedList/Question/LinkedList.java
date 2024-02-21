package Question;
import java.util.*;

public class LinkedList {

     public static class Node {
          int data;
          Node next;

          public Node(int data) {
               this.data = data;
               this.next = null;
          }
     }

     public static Node head;
     public static Node tail;
     public static int size;

     public void addFirst(int data) {
          // step 1
          Node newNode = new Node(data);

          // if linked list is empty
          if (head == null) {
               head = tail = newNode;
               return;
          }

          // link to another node
          newNode.next = head;
          // step 3
          head = newNode;
     }

     public void addLast(int data) {

          Node newNode = new Node(data);

          if (head == null) {
               head = tail = newNode;
               return;
          }

          // link to last node (created node)
          tail.next = newNode;

          // step 3
          tail = newNode;
     }

     // Slow-Fast Approach
     public Node findMid(Node head){
          Node slow = head;
          Node fast = head;

          while(fast != null && fast.next != null){
               slow = slow.next; //move by +1 
               fast = fast.next.next; // move by +2
          }

          // this return mid 
          return slow;
     }

     public boolean checkPalindrome(){

          // base case 
          if(head == null || head.next == null){
               return true;
          }

          // step1 find Mid
          Node mid = findMid(head);
     
          // step 2 reverse 2nd Linked List

          Node prev = null;
          Node curr = mid;
          Node next;

          while (curr != null) {
               next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
          }

          Node right = prev; //right half head 
          Node left = head;

          // step3 compare both left and right nodes

          while (right != null) {
               if(left.data != right.data) {
                    return false;
               }

               left = left.next;
               right = right.next;
          }
          // if all values match then return true
          return true;
     }



     public static void main(String[] args) {
          LinkedList ll = new LinkedList();

          ll.addLast(1);
          ll.addLast(3);
          ll.addLast(3);
          ll.addLast(1);

          // ll.print();
          System.out.println(ll.checkPalindrome());
          
     }
}
