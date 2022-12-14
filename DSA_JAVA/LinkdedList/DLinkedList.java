 
class DLL {
    private class Node{
        private int value;
        private Node next;
        private Node pre;

        Node(int val){
            this.value=val;
        }

        Node(int val,Node next,Node pre){
            this.value=val;
            this.next=next;
            this.pre=pre;
        }

    }

    private Node head;
    private Node tail;

    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        if(head!=null){
        head.pre=node;
        }
        head=node;

        if (tail==null) {
           tail=node; 
        }
    }

    public void insertLast(int val){
        Node node= new Node(val);
        if(tail!=null){
        tail.next=node;
        }
        node.pre=tail;
        tail=node;

        if (head==null) {
            head=node; 
        }

    }

    private Node traval(int val){
        Node node=head;
        while (node!=null) {
            if (node.value==val) {
                return node;
            }
            else{
                node=node.next;
            }

        }
        return null;
    }
  
    public void insert(int val, int After_value){
        Node temp=traval(After_value);
        if(temp!=null){
        Node node =new Node(val);
        if (temp==tail) {
            insertLast(val);
            return;
        }

        node.next=temp.next;
        temp.next.pre=node;
        temp.next=node;
        node.pre=temp;
    }

    }

    public void display(){
        Node node=head;
       System.out.print(" HEAD  ");
        while (node!=null) {
            System.out.print(node.value+" ");
            node=node.next;
        }
        System.out.print(" END "+"\n");

    }

    public void delete(int val){
        Node dnode=traval(val);

        if (dnode==head) {
            head=head.next;
            return;
        }
        if(dnode==tail){
            tail=tail.pre;
            tail.next=null;
            return;
        }

        dnode.pre.next=dnode.next;
        dnode.next.pre=dnode.pre;

    }
    
}
public class DLinkedList {
    public static void main(String[] args) {
        DLL dll=new DLL();
        dll.insertFirst(3);
        // dll.insertFirst(4);

        // dll.insertLast(5);

        // dll.insert(10, 3);
        // dll.insert(10, 4);
        // dll.insert(10, 5);

        // dll.display();

        // dll.delete(3);
        
        // dll.delete(5);
        // dll.delete(4);
        // dll.delete(10);
        // dll.delete(10);
        // dll.delete(10);
        dll.display();
        dll.delete(3);
        dll.display();
    }
    
}
