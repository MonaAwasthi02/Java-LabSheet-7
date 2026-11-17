import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Q1. Divide by Zero Exception (ArithmeticException)
 * Accept two integers, divide them, and handle a zero denominator
 * using try-catch-finally.
 */
class Divider {
    private final int numerator;
    private final int denominator;

    Divider(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    int divide() {
        return numerator / denominator; // throws ArithmeticException if denominator == 0
    }
}

public class Q01_DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();

            Divider divider = new Divider(a, b);
            System.out.println("Result = " + divider.divide());
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero! (" + e.getMessage() + ")");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers only.");
        } finally {
            System.out.println("Finally block executed: program finished.");
            sc.close();
        }
    }
}
