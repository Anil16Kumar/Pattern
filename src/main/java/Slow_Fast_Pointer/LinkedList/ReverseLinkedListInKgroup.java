package Slow_Fast_Pointer.LinkedList;

public class ReverseLinkedListInKgroup {
    public static LinkedList.Node reverseLinkedList(LinkedList.Node head){
        if(head==null)
            return null;

        LinkedList.Node prev=null;
        while(head!=null){
            LinkedList.Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static LinkedList.Node reverseLinkedList_FirstKOnly(LinkedList.Node head, int k) {
        if(head == null)
            return null;

        //int k = 2;

        LinkedList.Node prev = null;
        LinkedList.Node curr = head;

        while(curr != null && k-- > 0) {
            LinkedList.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr; // connect remaining nodes

        return prev;
    }

    public static LinkedList.Node SwapInPair(LinkedList.Node head){
        head = reverseLinkedList_KGroup(head, 2);
        return head;
    }

    public static LinkedList.Node reverseLinkedList_KGroup(LinkedList.Node head, int k){
        LinkedList.Node temp = head;
        int count = 0;

        while(temp != null && count < k){
            temp = temp.next;
            count++;
        }

        if(count < k)
            return head;

        int time = k;
        LinkedList.Node prev = null;
        LinkedList.Node curr = head;

        while(time-- > 0){
            LinkedList.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseLinkedList_KGroup(curr, k);

        return prev;
    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(23);
        ll.addData(43);
        ll.addData(78);
        ll.addData(65);
        ll.addData(12);
        ll.addData(10);
        ll.addData(90);
        ll.addData(78);
        ll.addData(98);
        ll.addData(88);

        ll.seeAll();
        System.out.println("=============================");

         ll.head =  reverseLinkedList(ll.head);
         ll.seeAll();

         ll.head = reverseLinkedList_FirstKOnly(ll.head, 2);
         ll.seeAll();
        ll.head = reverseLinkedList_FirstKOnly(ll.head, 2);

         ll.head = reverseLinkedList_KGroup(ll.head,2);
         ll.seeAll();
    }
}
