package Slow_Fast_Pointer.LinkedList;

public class IntersectionOfTwoLinkedLists {
    public static LinkedList.Node getIntersectionNode(LinkedList.Node headA, LinkedList.Node headB) {
        return null;
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addData(1);
        ll.addData(5);
        ll.addData(8);
        ll.addData(4);
        ll.addData(8);
        ll.addData(5);
        ll.addData(1);
        ll.seeAll();

        LinkedList ll1=new LinkedList();
        ll1.addData(1);
        ll1.addData(5);
        ll1.addData(8);
        ll1.addData(4);
        ll1.addData(8);
        ll1.addData(5);
        ll1.addData(1);
        ll1.seeAll();

        System.out.println(getIntersectionNode(ll.head, ll1.head));
    }
}
