import utils.MathUtils;

/** Intermediate Q9: import the utils package and call its static methods. */
public class Q09_UseMathUtils {
    public static void main(String[] args) {
        int a = 20, b = 6;
        System.out.println(a + " + " + b + " = " + MathUtils.add(a, b));
        System.out.println(a + " - " + b + " = " + MathUtils.subtract(a, b));
        System.out.println(a + " * " + b + " = " + MathUtils.multiply(a, b));
    }
}
