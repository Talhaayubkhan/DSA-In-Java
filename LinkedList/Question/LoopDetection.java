package Question;

import java.util.*;

public class LoopDetection {

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

     public static boolean cycleDetected() {

          Node slow = head;
          Node fast = head;

          while (fast != null && fast.next != null) {

               slow = slow.next; // +1
               fast = fast.next.next; // +2

               if (slow == fast) {
                    return true; // loop detected
               }
          }

          return false; // this means linked list is single
     }

     public static void removeCycle() {
          // detect / loop Cycle
          Node slow = head;
          Node fast = head;
          boolean cycle = false;

          while (fast != null && fast.next != null) {
               slow = slow.next; // +1
               fast = fast.next.next; // +2
               if (fast == slow) {
                    cycle = true;
                    break;
               }
          }
          //if cycle did not exist, then return
          if (cycle == false) {
               return;
          }

          // find meeting point if cycle exists
          slow = head;
          Node prev = null;

          while (slow != fast) {
               prev = fast;
               slow = slow.next; //+1
               fast = fast.next; //+1
          }

          // remove Cycle  last.next = null;
          prev.next = null;
     }

     public static void main(String[] args) {
          LinkedList ll = new LinkedList();
          head = new Node(1);
          head.next = new Node(2);
          head.next.next = new Node(3);
          head.next.next.next = head;
          // 1->2->3->1

          System.out.println(cycleDetected());
          removeCycle();
          System.out.println(cycleDetected());
     }
}
