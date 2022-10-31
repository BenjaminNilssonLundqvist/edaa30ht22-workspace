package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookReaderApplication {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(
				new File("/Users/benjamin/edaa30ht22-workspace/edaa30ht22-workspace-1/lab2/nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

        Scanner u = new Scanner(new File("./lab3/undantagsord.txt"));
        
        
    }
    
    
}
