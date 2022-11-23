package mountain;

import java.util.function.DoubleBinaryOperator;

import javax.print.attribute.standard.Sides;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Bergsfraktal extends Fractal {
    int length;
    double dev;

    public Bergsfraktal(int length, double dev) {
        super();
        this.length = length;
        this.dev = dev;

    }

    @Override
    public String getTitle() {
        return "Bergsfraktal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        Point a = new Point(150, 450);
        Point c = new Point(450, 350);
        Point b = new Point(350, 130);

        mountainLine(turtle, order, a, b, c, dev);

    }

    // TODO Auto-generated method stub
    public Point mid(Point a, Point b) {
        return b;

    }

    public void mountainLine(TurtleGraphics t, int order, Point a, Point b, Point c, Double dev) {
        if (order == 0) {
            t.penUp();
            t.forwardTo(a.getX(), a.getY());
            t.penDown();
            t.forwardTo(b.getX(), b.getY());
            t.forwardTo(c.getX(), c.getY());
            t.forwardTo(a.getX(), a.getY());
        } else {
            int offset1 = (int) RandomUtilities.randFunc(dev);
            dev=dev/2;

            Point ab = new Point(((a.getX() + b.getX())/2), ((a.getY()+b.getY())/2- offset1));
            Point bc = new Point(((b.getX() + c.getX())/2), ((b.getY()+c.getY())/2- offset1));
            Point ca = new Point(((c.getX() + a.getX())/2), ((c.getY()+a.getY())/2- offset1));

           // mountainLine(t, order - 1, a, ab, ca, dev);
           // mountainLine(t, order - 1, ab, b, ca, dev);
           // mountainLine(t, order - 1, ab, bc, c, dev);
            //mountainLine(t, order - 1, ab, bc, ca, dev);
            mountainLine(t, order-1, a, ab, ca, dev);
            mountainLine(t, order-1, ca, bc, c, dev);
            mountainLine(t, order-1, ab, b, bc, dev);
            mountainLine(t, order-1, ab, bc, ca, dev);
           
        }
        
    }

}
