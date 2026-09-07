package Slow_Fast_Pointer.LinkedList;

public class StartingPointInLinkedListLoop {
    // return the starting point of linked list contain the loop
    public static LinkedList.Node detectCycle(LinkedList.Node head){
        LinkedList.Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int idx=0;
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                    idx++;
                }
                return slow;
            }
        }
        return null;
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
        System.out.println(detectCycle(ll.head));
    }
}
