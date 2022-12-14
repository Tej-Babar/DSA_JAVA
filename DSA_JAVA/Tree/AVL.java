import java.util.Scanner;

class Tree {
    private class Tnode {

        private int value;
        private Tnode left;
        private Tnode right;

        Tnode(int val){
            this.value=val;
            this.left=null;
            this.right=null;
        } 
    }

    public Tnode root;

    Tree(){
        root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    private int height(Tnode node){
        if (node==null) {
            return -1;
        }
        int lheight=height(node.left);
        int rheight=height(node.right);

        if(lheight>rheight){
            return lheight+1;
        }
        else{
            return rheight+1;
        }
    }

    private int BF(Tnode node){
        return height(node.left)-height(node.right);
    }

    private Tnode RightRotate(Tnode node){
        Tnode Rtemp=node.left;
        Rtemp.left=node.left.left;
        node.left=node.left.right;
        Rtemp.right=node;


        return Rtemp;
    }

    private Tnode LeftRotate(Tnode node){
        Tnode Rtemp=node.right;
        Rtemp.right=node.right.right;
        node.right=node.right.left;
        Rtemp.left=node;

        return Rtemp;
    }


    public Tnode insertRec(Tnode node,int val){

        if (node==null) {
            node=new Tnode(val);
            return node;
        }

        else if(node.value>val){
            node.left=insertRec(node.left, val);
        }
        else if(node.value<val){
            node.right=insertRec(node.right, val);
        }
        else{
            System.out.println("Duplicate node");
            return node;
        }
        if (BF(node)>1 && node.left.value>val) {
            return RightRotate(node);
        }

        else if(BF(node)>1){
            Tnode temp=LeftRotate(node.left);
            return RightRotate(node);
        }

        else if(BF(node)<-1 && node.right.value<val){
            return LeftRotate(node);
        }

        else if(BF(node)<-1){
            Tnode temp=RightRotate(node.right);
            return LeftRotate(node);
        }
        return node;
    }

    public void BFS(){
        for (int i = 0; i <= height(root); i++) {
            PrintBFS(root,i);
        }
    }

    private void PrintBFS(Tnode node, int l) {
        if (node==null) {
            return;
        }
        if (l==0) {
            System.out.print(node.value+" ");
        }
        else{
            PrintBFS(node.left, l-1);
            PrintBFS(node.right, l-1);
        }
    }

    public void Print2D(Tnode node,int space){
        if (node==null) {
            return;
        }

        Print2D(node.left, space+1);
        for (int i = 0; i <space; i++) {
            System.out.print("     ");
        }
        System.out.print(node.value+"\n\n");
        Print2D(node.right, space+1);


    }

    public Tnode Search(int val){
        Tnode node=root;
        while (node!=null) {
            if (node.value==val) {
                return node;
            } else if(node.value>val) {
                node=node.left;
            }
            else{
                node=node.right;
            }
        }
        return null;
    }

    public Tnode minValue(Tnode node){

        while (node.left!=null) {
            node=node.left;
        }
        return node;
    }

    public Tnode Delete(Tnode node,int val){
        if(node==null){
            return null;
        }
        if (node.value>val) {
            node.left=Delete(node.left, val);
        }
        else if (node.value<val) {
            node.right=Delete(node.right, val);
        }
        else{
            if (node.left==null) {
                return node.right;
            } else if(node.right==null){
                return node.left;
            }
            else{
                Tnode temp=minValue(node.right);
                node.value=temp.value;
                node.right=Delete(node.right, temp.value);
            }
        }

        int bf=BF(node);
        if (bf==2 && BF(node.left)>=0) {
            return RightRotate(node);
        }
        else if(bf==2 && BF(node.left)==-1){
            node.left=LeftRotate(node.left);
            return RightRotate(node);
        }

        else if(bf==-2 && BF(node.right)<=0){
            return LeftRotate(node);
        }
        else if(bf==-2 && BF(node.right)==1){
            node.right=RightRotate(node.right);
            return LeftRotate(node);
        }

        return node;


    }
}

public class AVL{
    public static void main(String[] args) {
            Tree tree=new Tree();
            Scanner sc = new Scanner(System.in);
            int val,ch;
            do {
    
                System.out.println("\n"+"Enter your choice ");
    
                System.out.println("Enter 1 for insert node ");
                System.out.println("Enter 2 for Preorder ");
                System.out.println("Enter 3 for Ineorder ");
                System.out.println("Enter 4 for Postorder ");
                System.out.println("Enter 5 for 2D Print");
                System.out.println("Enter 6 for BFS");
                System.out.println("Enter 7 for Delete node");
    
                System.out.println("Enter 0 for exit ");
    
                ch=sc.nextInt();
    
                switch (ch) {
                    case 0:
                        
                        break;
                    case 1:
                        System.out.println("Enter the value ");
                        val=sc.nextInt();
                        tree.root=tree.insertRec(tree.root, val);
                        break;
                    
                    case 2:
                       // tree.Preorder(tree.root);
                        break;
    
                    case 3:
                       // tree.Inorder(tree.root);
                        break;
                    
                    case 4:
                       // tree.Postorder(tree.root);
                        break;
                    
                    case 5:
                        System.out.println("*** 2D ***");
                        tree.Print2D(tree.root, 0);
                        break;
                    
                    case 6:
                        tree.BFS();
                        break;
                    
                    case 7:
                        System.out.println("Enter the value to delete ");
                        val=sc.nextInt();
    
                        if (tree.Search(val)==null) {
                            System.out.println("Node not exist");
                        } else {
                           tree.root=tree.Delete(tree.root, val);
                            System.out.println("Node delete susesfully !!!");
                        }
                        break;
                
                    default:
                        System.out.println("Enter correct Choice ");
                        break;
                }
    
    
                
            } while (ch!=0);
    
            sc.close();
    
    }
}
