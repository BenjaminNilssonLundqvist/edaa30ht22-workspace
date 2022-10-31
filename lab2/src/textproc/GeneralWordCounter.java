package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
    private Set<String> stopwords;
    private Map<String, Integer> WordList = new TreeMap<String, Integer>();

    public GeneralWordCounter(Set<String> s) {
        this.stopwords = s;
    }

    @Override
    public void process(String w) {
        if (!stopwords.contains(w)) {
            WordList.put(w, WordList.getOrDefault(w, 0) + 1); // Fattar inte denna raden

        } else {

        }
        // TODO Auto-generated method stub

    }



    @Override
    public void report() {
        // for(String key:WordList.keySet()){
        // if(WordList.get(key)>200){
        // // System.out.println("Ord "+ key+" finns "+ WordList.get(key));
        // }
        Set<Map.Entry<String, Integer>> wordSet = WordList.entrySet();
        List<Map.Entry<String, Integer>> wordlist = new ArrayList<Map.Entry<String, Integer>>(wordSet);
        //wordlist.sort((a,b)-> a.getKey().compareTo(b.getKey()));
        wordlist.sort((a,b) ->b.getValue().compareTo(a.getValue()));
        
        for (int i = 0; i < 200; i++) {
            System.out.println(wordlist.get(i).getKey() + " " + wordlist.get(i).getValue());

        }

    }
    public List<Map.Entry<String, Integer>> getWordList(){
        List<Map.Entry<String,Integer>> wordlist= new ArrayList<>(WordList.entrySet());
        return wordlist;
    }
    // TODO Auto-generated method stub

}
