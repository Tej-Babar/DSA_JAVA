
class Cll{

    private class Node{
        private int value;
        Node next;

        Node(int val){
            this.value=val;
        }
    }

        private Node head;
        private Node tail;
        public void insertFirst(int val){
            Node node= new Node(val);
            if (head==null) {
                head=tail=node;
                tail.next=head;
                return;
            }

            node.next=head;
            head=node;

        }

        public void insertLast(int val){
            Node node=new Node(val);
            if (head==null) {
                insertFirst(val);
            }

            tail.next=node;
            node.next=head;
            tail=node;
        }

        public void insert(int val,int index){
            Node node=new Node(val);
            Node temp=head;

            for (int i = 0; i < index; i++) {
                temp=temp.next;      
            }
            node.next=temp.next;
            temp.next=node;


        }

        public void display(){
            Node run=head;

            do {
                System.out.print(run.value+" ");
                run=run.next;
            } while (run!=tail);
        }
    

}

public class CLinkedList {

    public static void main(String[] args) {
        Cll cll=new Cll();
        cll.insertFirst(5);
        cll.insertFirst(4);
        cll.insertFirst(3);
        cll.insertFirst(2);
        cll.insertFirst(1);

        cll.display();
    }
    
}
