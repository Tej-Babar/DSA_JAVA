class Heep{
    private int heep[];
    private int Size;
    private int ptr;
    Heep(int s){
        Size=s;
         heep=new int[s];
         ptr=0;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private void swap(int f,int s){
        int temp=heep[f];
        heep[f]=heep[s];
        heep[s]=temp;
    }

    public void insert(int val){
        if (ptr==Size-1) {
            System.out.println("Heep is full");
            return;
        } else {
            heep[ptr]=val;
            int i=ptr;
            ptr++;
            while (i!=0 && heep[parent(i)]>heep[i]) {
                swap(parent(i),i);
                i=parent(i);
            }
        }
    }


    public void display(){
        for (int i : heep) {
            System.out.print(i+" ");
        }
    }
}
public class MinHeep {
    public static void main(String[] args) {
        Heep heep=new Heep(10);
        heep.insert(56);
        heep.insert(10);
        heep.insert(2);
        heep.insert(3);
        heep.display();
        
    }
}
