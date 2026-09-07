package Slow_Fast_Pointer.LinkedList;

public class LinkedList {
    public class Node{
        int val;
        Node next;
        Node(int data){
            this.val=data;
            this.next=null;
        }
    }

    public Node head=null;

    public void addData(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=new Node(data);
    }

    public void seeAll(){
        if(head==null)
            return;
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
