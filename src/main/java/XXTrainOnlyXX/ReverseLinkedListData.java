package XXTrainOnlyXX;

public class ReverseLinkedListData {
    public static LinkedListDS.Node reverseTheLinkedList(LinkedListDS.Node head){
        LinkedListDS.Node prev=null;

        while(head!=null){
            LinkedListDS.Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkedListDS ll=new LinkedListDS();
        ll.addValue(12);
        ll.addValue(34);
        ll.addValue(23);
        ll.addValue(55);
        ll.addValue(90);
        ll.addValue(98);
        ll.addValue(44);

        ll.viewAll();
        System.out.println();
        System.out.println("==========================");
        ll.head=reverseTheLinkedList(ll.head);

        ll.viewAll();
    }
}
