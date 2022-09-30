import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> nbrs= new ArrayList<>(List.of(1,2,3,-4,-8,10,0,3,2,22));
        nbrs.sort((a,b)->(a-b));
        nbrs.forEach((s)-> System.out.println(s));
        nbrs.removeIf(a-> a<0);
        nbrs.forEach((s)-> System.out.println(s));
        nbrs.sort((c,d)-> d-c);
        nbrs.forEach((s)-> System.out.println(s));
        
        
    }
    
}
