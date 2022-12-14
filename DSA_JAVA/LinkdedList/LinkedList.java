class LL{

    private class Node{
    
        private int value;
        private Node next;

        Node(int val){
            this.value=val;
            this.next=null;
        }  
    }

    private Node head;
    private Node tail;

    void insertFirst(int val){
        Node node =new Node(val);
        node.next=head;
        head=node;

        if (head.next==null) {
            tail=head;
        }

    }


    void insertLast(int val){
        Node node=new Node(val);
        tail.next=node;
        tail=node;
    }

    void insert(int val,int index){
        if (index==1) {
            insertFirst(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
        temp=temp.next;
           
        }
        Node node=new Node(val);
        node.next=temp.next;
        temp.next=node;
    }

    void delete(int val){
        if (head.value==val) {
            head=head.next;
            return;
        }
        Node temp=head;
        if (tail.value==val) {
            while (temp.next!=tail) {
                temp=temp.next;
            }
            tail=temp;
           
        }
        while(temp.next.value!=val){
            temp=temp.next;
        }
        temp.next=temp.next.next;

    }

    void ReverseList(){
        // tail=Reverse1(head, head.next);
        // tail.next=null;

        Reverse2(head);
    }

    Node Reverse1(Node at,Node At_Next){
        if(at==tail){
            head=tail;
            return tail;
        }
        Node temp=Reverse1(at.next, At_Next.next);
        temp.next=at;
        return at;

    }

    void Reverse2(Node node){
        if(node==tail){
            head=tail;
            return;
        }

        Reverse2(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.value + "->");
            temp=temp.next;
        }
        System.out.println();
    }



}
public class LinkedList{
    public static void main(String[] args) {
        
        LL ll=new LL();
        ll.insertFirst(10);
       // ll.insertFirst(20);

        ll.insertLast(50);
        ll.insertLast(51);
        ll.insertLast(52);
        ll.insertLast(53);
        ll.insertLast(54);
        ll.insertLast(55);

        // ll.insert(30, 2);
        // ll.insert(40, 2);

       // ll.insertLast(20);
        // ll.insert(5, 3);
        // ll.insert(5, 3);
        // ll.insert(5, 3);
        // ll.display();
        // ll.delete(5);
        // ll.delete(5);

        ll.display();
        ll.ReverseList();
        ll.display();
        
    }
}