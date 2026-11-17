import shapes.Circle;
import shapes.Rectangle;

/** Intermediate Q2: use both classes of package "shapes". */
public class Q02_UseShapes {
    public static void main(String[] args) {
        Circle c = new Circle(7);
        Rectangle r = new Rectangle(5, 4);

        System.out.printf("Area of Circle (r=7)        = %.2f%n", c.area());
        System.out.printf("Area of Rectangle (5 x 4)   = %.2f%n", r.area());
    }
}
