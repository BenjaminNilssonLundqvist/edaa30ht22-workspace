package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{
    Map<String,Integer> Wordmap= new HashMap<String,Integer>();
    String[] vektor;
    int n=0;

    public MultiWordCounter(String [] s){
 
        for(String s1:s){
            Wordmap.put(s1, 0);
        }
        
        
        
    }

    @Override
    public void process(String w){
        if(Wordmap.containsKey(w)){
            Wordmap.put(w,Wordmap.get(w)+1);


        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public void report() {
        for(String Key:Wordmap.keySet()){
            System.out.println("Key: "+ Key + " finns "+Wordmap.get(Key)+" gånger");

        }
        // TODO Auto-generated method stub
        
    }
    
}
