package Slow_Fast_Pointer.LinkedList;

public class LoopInLinkedList {
    public static boolean hasLoop(LinkedList.Node head){
        LinkedList.Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(12);
        ll.addData(45);
        ll.addData(90);
        ll.addData(87);
        ll.addData(52);
        ll.addData(89);
        ll.seeAll();
        System.out.println(hasLoop(ll.head));
    }
}
