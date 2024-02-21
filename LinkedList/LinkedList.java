
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

        // step1
        Node newNode = new Node(data);
        size++;
        // if linked list empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2
        // we actually link to another node
        newNode.next = head;

        // step3
        head = newNode;

    }

    public void addLast(int data) {
        // step1
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2
        tail.next = newNode;
        // step3
        tail = newNode;
    }

    public void print() {

        // if (head == null) {
        // System.out.println("LinkList is Empty");
        // return;
        // }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        size++;
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // when temp = previous
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        Node prev = head;
        // we want second last element , so we need i = size-2
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int search(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                // key found case
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not Found
        return -1;
    }

    public int helper(Node head, int key) {
        // base case if not found
        if (head == null) {
            return -1;
        }

        // if found then return 0 , why 0? because head position on 3 so header consider
        // as 0 than return 0 and idx+1;
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        // if not found than -1, if found than -1 becomes 0 and than 1 and than 2 and
        // return key position;
        if (idx == -1) {
            return -1;
        }

        // this will add 0 + 1 + 1 = 2
        return idx + 1;

    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteFromMiddle(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // corner case, what if we delete our head in some case
        if (n == sz) {
            head = head.next;
            return;
        }

        // sz-1;

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    private Node getMid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // find the mid
    }

    private Node mergeBoth(Node head1, Node head2) {

        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // findMid
        Node mid = getMid(head);

        // left and right
        Node rightHead = mid.next;
        mid.next = null;
        
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(rightHead);

        // mergeBoth
        return mergeBoth(leftSorted, rightSorted); 
    }


    public void zigZag(){

        // find mid 

        Node slow = head;
        Node fast = head.next;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // reverse the 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        // zig-zag merge
        while( left != null && right != null){

            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // for update both heads
            right = nextR;
            left = nextL;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}