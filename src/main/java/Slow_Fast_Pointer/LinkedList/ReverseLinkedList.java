package Slow_Fast_Pointer.LinkedList;

public class ReverseLinkedList {
    public static LinkedList.Node reverseLinkedList(LinkedList.Node head){

        LinkedList.Node prev=null;
        while(head!=null){
            LinkedList.Node nxt=head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(12);
        ll.addData(52);
        ll.addData(89);
        ll.addData(45);
        ll.addData(90);
        ll.addData(91);
        ll.addData(100);
        ll.seeAll();
        ll.head = reverseLinkedList(ll.head);
        ll.seeAll();
    }
}
