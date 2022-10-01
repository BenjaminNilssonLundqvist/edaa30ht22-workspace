package textproc;
import java.util.ArrayList;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private ArrayList<String> wordList;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		if (w.equals(word)){
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
