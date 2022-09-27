import java.util.HashMap;
import java.util.Set;

public class nbrUnik {
    public static void main(String[] args) {
        int a [] = {10,9,8,7,6,5,5,4,4,3,3,2,2,1,1};
        System.out.println(nbrUnique(a));
    }
    public static int nbrUnique(int[] a) {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();   
        int count=0;
        for(int i=0;i<a.length;i++){
            hashmap.put(a[i],i);
        }
        for(int j:hashmap.keySet()){
            count++;
            
        }
        
        return count;
    }
}
