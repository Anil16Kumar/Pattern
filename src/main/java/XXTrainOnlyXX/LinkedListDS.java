package XXTrainOnlyXX;

public class LinkedListDS {
    public class Node{
        int data;
        Node next;
        public Node(int value){
            this.data=value;
            this.next=null;
        }
    }

    public Node head = null;

    public void addValue(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
             temp=temp.next;
        }
        temp.next=new Node(data);
        return;
    }

    public void viewAll(){
        if(head==null)
            return;
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        return;
    }


}
