package LinkedListQuestions;

import java.util.LinkedList;

public class FirstLinkList {
     public static class Node{
          int data;
          Node next;

          public Node(int data){
               this.data = data;
               this.next = null;
          }
     }
          public static Node head;
          public static Node tail;
          
     
     public static void main(String[] args) {
          LinkedList<Integer> ll = new LinkedList<>();

          ll.addFirst(3);
          ll.addFirst(2);
          ll.addFirst(1);
          // System.out.print(ll);
          // System.out.println(ll);
          // ll.removeFirst();
          System.out.println(ll);
          ll.removeLast();
          System.out.println(ll);
     }
}
