import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;



class Graph{
    private class Edge{
        private int DestinationVID;
        private int Weight;

  

        Edge(int d,int w){
            this.DestinationVID=d;
            this.Weight=w;
        }

        public void setWeight(int w){
            this.Weight=w;
        }
        public void setD_VID(int id){
            this.DestinationVID=id;
        }

        public int getWeight(){
            return Weight;
        }

        public int getD_VID(){
            return DestinationVID;
        }   

    }
    public class Vertex{
        private int state_id;
        private String state_name;
        List<Edge> edgelist=new ArrayList<Edge>();

        Vertex(){
            this.state_id=0;
            this.state_name=null;
        }

        Vertex(int id,String s_n){
            this.state_id=id;
            this.state_name=s_n;
        }

        public int getStateID() {
            return state_id;
          }
        public String getStateName() {
            return state_name;
          }
        public void setID(int id) {
            state_id = id;
        }
        public void setStateName(String sname) {
         state_name = sname;
        }
        
        public List getList(){
            return edgelist;
        }
    }


    Vector<Vertex> vertices=new Vector<>();

    private boolean checkIfVertexExistByID(int id){
        boolean flag=false;
        for(int i=0;i<vertices.size();i++){
            if (vertices.elementAt(i).state_id==id) {
                flag=true;
            }
        }
        return flag;
    }

    public void addVertex(int id,String name){
        boolean check=checkIfVertexExistByID(id);
        if (check) {
            System.out.println("Vertex with this ID already exist");
        } else {
            Vertex newVertex=new Vertex(id, name);
            vertices.add(newVertex);
            System.out.println("New Vertex Added Successfully");
        }
    }
    private Edge getEdgeById(Vertex v,int id){
        for (int i = 0; i <v.edgelist.size(); i++) {
            if (v.edgelist.get(i).DestinationVID==id) {
                return v.edgelist.get(i);
            }
        }
        return null;
    }
    public Vertex getVertexById(int id){
        for(int i=0;i<vertices.size();i++){
            if (vertices.elementAt(i).state_id==id) {
                return vertices.elementAt(i);
            }
        }
        return null;
    }

    public boolean checkIfEdgeExistByID(int from,int to){
        Vertex v=getVertexById(from);
        List<Edge> list;
        list=v.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).DestinationVID==to) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(int fromVertex,int toVertex,int w){
        boolean c1=checkIfVertexExistByID(fromVertex);
        boolean c2=checkIfVertexExistByID(toVertex);
        boolean c3=checkIfEdgeExistByID(fromVertex,toVertex);

        if (c1 && c2) {
            if (c3) {
                System.out.println("Edge is already Exit ");
            }
            else{
                for (int i = 0; i < vertices.size(); i++) {
                    if (vertices.elementAt(i).state_id==fromVertex) {
                        Edge edge=new Edge(toVertex, w);
                        vertices.elementAt(i).edgelist.add(edge);
                        System.out.println("Edge added between "+fromVertex+" to "+toVertex);
                    }

                    else if (vertices.elementAt(i).state_id==toVertex) {
                        Edge edge=new Edge(fromVertex, w);
                        vertices.elementAt(i).edgelist.add(edge);
                        System.out.println("Edge added between "+toVertex+" to "+fromVertex);
                    }
                }
            }
        }
    }

    public void printGraph(){
        for (int i = 0; i < vertices.size(); i++) {
            Vertex temp= vertices.elementAt(i);
            System.out.print("( "+temp.state_id+" )"+"  ( "+temp.state_name+" )"+" [");
            printEdge(temp);
            System.out.println(" ] ");
            
        }
    }

    public void printEdge(Vertex vertex){
        for (int j = 0; j <vertex.edgelist.size(); j++) {
            int id=vertex.edgelist.get(j).DestinationVID;
            String name=getVertexById(id).state_name;
            System.out.print(" ( "+ name+" "+
            vertex.edgelist.get(j).Weight+" ) ");
        }
    }

    public void updateVertex(int id,String name){
        Vertex v=getVertexById(id);
        v.setStateName(name);
               
    }

    public void deletVertex(int id){
        deleteEdge(id);
        Vertex v=getVertexById(id);
        vertices.remove(v);
        System.out.println("Vertex delete susesfully !!");
    }

    private void deleteEdge(int V_del_id){
        Vertex v_del=getVertexById(V_del_id);
        
        for (int i = 0; i < v_del.edgelist.size(); i++) {
            int did=v_del.edgelist.get(i).DestinationVID;
            Vertex vid=getVertexById(did);
            Edge dEdge=getEdgeById(vid, V_del_id);
            vid.edgelist.remove(dEdge);
    
        }

    }

    public void DeleteEdge(int from,int to){
        Vertex vid1=getVertexById(from);
        Edge dEdge1=getEdgeById(vid1, to);
        vid1.edgelist.remove(dEdge1);

        Vertex vid2=getVertexById(to);
        Edge dEdge2=getEdgeById(vid2, from);
        vid2.edgelist.remove(dEdge2);

        System.out.println("Edge delete susesfully !!");
    }

    public void UpdateEdge(int from,int to,int w){
        Vertex vid1=getVertexById(from);
        Edge UEdge1=getEdgeById(vid1, to);
        vid1.edgelist.get(vid1.edgelist.indexOf(UEdge1)).setWeight(w);

        Vertex vid2=getVertexById(to);
        Edge UEdge2=getEdgeById(vid2, from);
        vid2.edgelist.get(vid2.edgelist.indexOf(UEdge2)).setWeight(w);

        System.out.println("Edge updated !! ");
    }

    public void CheckIfEd(int from,int to){
        Vertex v=getVertexById(from);
        for (int i = 0; i < v.edgelist.size(); i++) {
            if (v.edgelist.get(i).DestinationVID==to) {
                System.out.println("");
            }
        }
    }
}

public class Graph_main {
    public static void main(String[] args) {
        Graph graph=new Graph();
        Scanner sc=new Scanner(System.in);

     

       
        int vid,Weight,from_V,to_V,ch;
        String Vname;

        do {
            System.out.println("Enter your choise ");
            System.out.println("Enter 1 for Add Vertex");
            System.out.println("Enter 2 for Add Edge");
            System.out.println("Enter 3 for Delete Vertex");
            System.out.println("Enter 4 for Delete Edge");
            System.out.println("Enter 5 for Update Vertex");
            System.out.println("Enter 6 for Update Edge");
            System.out.println("Enter 7 for Check if Edge Exist Or Not");
            System.out.println("Enter 8 for Print all Edge of Vertx");
            System.out.println("Enter 9 for Print Graph");
            System.out.println("Enter 0 for Exit");
            ch=sc.nextInt();

            switch (ch) {
                case 0:
                    
                    break;
                case 1:
                System.out.println("Enter ID of Vertex");
                vid=sc.nextInt();
                System.out.println("Enter Name of Vertex");
                Vname=sc.next();
                graph.addVertex(vid, Vname);
                break;

                case 2:
                System.out.println("Enter from ID of Vertex");
                from_V=sc.nextInt();
                System.out.println("Enter to id of Vertex");
                to_V=sc.nextInt();
                System.out.println("Enter to Weight of Edge");
                Weight=sc.nextInt();
                graph.addEdge(from_V, to_V,Weight);
                break;

                case 3:
                System.out.println("Enter Id for Delete vertex");
                vid=sc.nextInt();
                graph.deletVertex(vid);
                break;
                
                case 4:
                System.out.println("Enter from Edge id");
                from_V=sc.nextInt();
                System.out.println("Enter to Edge id");
                to_V=sc.nextInt();
                graph.DeleteEdge(from_V, to_V);
                break;

                case 5:
                System.out.println("Enter Id for Update vertex");
                vid=sc.nextInt();
                System.out.println("Enter Name of Vertex");
                Vname=sc.next();
                graph.updateVertex(vid, Vname);
                break;

                case 6:
                System.out.println("Enter from Edge id");
                from_V=sc.nextInt();
                System.out.println("Enter to Edge id");
                to_V=sc.nextInt();
                System.out.println("Enter The Weight");
                Weight=sc.nextInt();
                graph.UpdateEdge(from_V, to_V, Weight);
                break;

                case 7:
                System.out.println("Enter from Edge id");
                from_V=sc.nextInt();
                System.out.println("Enter to Edge id");
                to_V=sc.nextInt();
                if (graph.checkIfEdgeExistByID(from_V,to_V)) {
                    System.out.println("Edge Exist ");
                } else {
                    System.out.println("Edge not Exist");
                }
                break;

                case 8:
                System.out.println("Enter the id of Vertex");
                vid=sc.nextInt();
                graph.printEdge(graph.getVertexById(vid));
                System.out.println();
                break;

                case 9:
                graph.printGraph();
                break;


                default:
                    break;
            }

            
        } while (ch!=0);
  
    }
}
