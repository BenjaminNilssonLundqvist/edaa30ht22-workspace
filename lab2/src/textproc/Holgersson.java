package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();

		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));

		Scanner s = new Scanner(
				new File("/Users/benjamin/edaa30ht22-workspace/edaa30ht22-workspace-1/lab2/nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor t : list) {
				t.process(word);
			}
		}

		s.close();
		for (TextProcessor t : list) {
			t.report();
		}
	}
}