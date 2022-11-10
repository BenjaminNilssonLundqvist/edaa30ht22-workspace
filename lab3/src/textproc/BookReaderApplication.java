package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//import lpt.TestScheduler;

public class BookReaderApplication {

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> stopwords = new HashSet<String>();
        ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
        GeneralWordCounter gwc= new GeneralWordCounter(stopwords);

        Scanner scan = new Scanner(new File("C:/Users/benja/Desktop/edaa30ht22-workspace/edaa30ht22-workspace-1/lab3/undantagsord.txt"));
        while (scan.hasNext()) {
            String stopword = scan.next().toLowerCase();
            stopwords.add(stopword);
        }
// ändra till mac! // och filepath
        Scanner s = new Scanner(
                new File("lab3/nilsholg.txt"));
        s.findWithinHorizon("/uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

        list.add(gwc);

        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            for (TextProcessor t : list) {
                t.process(word);
            }
        }
        for (TextProcessor t : list) {
            t.report();
        }

        new BookReaderController(gwc);
         
         s.close();
         scan.close();

    }

}
