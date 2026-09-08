package Slow_Fast_Pointer.LinkedList;

public class MiddleOfTheLinkedList {
    public static LinkedList.Node middleNode(LinkedList.Node head) {
        if(head==null)
            return null;

        LinkedList.Node slow=head;
        LinkedList.Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(12);
        ll.addData(45);
        ll.addData(90);
        ll.addData(87);
        ll.addData(52);
        ll.addData(89);
        ll.addData(98);
        ll.seeAll();
        System.out.println(middleNode(ll.head).val);
    }
}
