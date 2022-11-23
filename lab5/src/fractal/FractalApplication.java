package fractal;

import koch.Koch;
import mountain.Bergsfraktal;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1]= new Bergsfraktal(300, 15);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
