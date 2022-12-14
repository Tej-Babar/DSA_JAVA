import java.util.ArrayList;
//import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSet_EX {
    public static void main(String[] args) {
        HashSet<Integer>  set = new HashSet<>();
        
        HashSet<Integer> list=new HashSet<>();
        list.add(6);
        list.add(9);
       

        set.add(6);
        set.add(9);
        // set.add(5);
        // set.add(3);
        //set.addAll(list);

       // set.clear();    Remove all Elements

       System.out.println(set.equals(list));

        Iterator<Integer> it=set.iterator();
        

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        
        
        //System.out.println(set);
    }
}
