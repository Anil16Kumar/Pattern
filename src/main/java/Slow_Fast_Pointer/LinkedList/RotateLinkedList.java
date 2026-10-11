package Slow_Fast_Pointer.LinkedList;

public class RotateLinkedList {
    public static LinkedList.Node rotateOnlyOnes(LinkedList.Node head){
        if(head == null || head.next==null)
            return head;

        LinkedList.Node frontPointer = head.next;
        LinkedList.Node rearPointer = head;

        while(frontPointer!=null){
            int temp = rearPointer.val;
            rearPointer.val = frontPointer.val;
            frontPointer.val = temp;
            rearPointer = frontPointer;
            frontPointer = frontPointer.next;
        }

        return head;
    }
    // this rotate list in left...
    public static LinkedList.Node rotateTheLinkedList(LinkedList.Node head, int k){
        if(k<2)
            return head;

        while ((k)-->0){
            head = rotateOnlyOnes(head);
        }

        return head;
    }

    public static LinkedList.Node rotateRight(LinkedList.Node head, int k) {

        if(head == null || head.next == null || k == 0)
            return head;

        int size = 1;
        LinkedList.Node tail = head;

        while(tail.next != null){
            tail = tail.next;
            size++;
        }

        k %= size;

        if(k == 0)
            return head;

        int steps = size - k - 1;

        LinkedList.Node newTail = head;

        while(steps-- > 0){
            newTail = newTail.next;
        }

        LinkedList.Node newHead = newTail.next;

        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(23);
        ll.addData(34);
        ll.addData(90);
        ll.addData(298);
        ll.addData(22);
        ll.addData(66);
        ll.addData(8899);
        ll.addData(989);
        ll.addData(230);

        ll.seeAll();
        ll.head = rotateRight(ll.head, 3);
        //ll.head = rotateTheLinkedList(ll.head,ll.linkedListSize() - 3);
        ll.seeAll();

    }
}
/*
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]
* */