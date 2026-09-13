package Slow_Fast_Pointer.LinkedList;

public class Palindrome {
    public static boolean palindromeLinkedList(LinkedList.Node head){
        LinkedList.Node slow=head;
        LinkedList.Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        LinkedList.Node prev=null;
        while(slow!=null){
            LinkedList.Node nxt=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nxt;
        }

        LinkedList.Node first=head;
        LinkedList.Node second=prev;
        while(second!=null){
            if(first.val!=second.val)
                return false;

            first=first.next;
            second=second.next;
        }
        return true;
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
        System.out.println(palindromeLinkedList(ll.head));
    }
}
