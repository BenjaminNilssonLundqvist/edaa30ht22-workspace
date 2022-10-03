package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor{
    private Set<String> stopwords;
    private Map<String,Integer> WordList= new HashMap<String,Integer>();

    public GeneralWordCounter(Set<String> s){
        this.stopwords=s;
    }

    @Override
    public void process(String w) {
        if(!stopwords.contains(w)){
            WordList.put(w, WordList.getOrDefault(w, 0)+1); //Fattar inte denna raden

        } else{
    
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public void report() {
        for(String key:WordList.keySet()){
            if(WordList.get(key)>200){
                System.out.println("Ord "+ key+" finns "+ WordList.get(key));

            }
            
            

        }
        // TODO Auto-generated method stub
        
    }
    
}
