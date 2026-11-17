import java.util.Scanner;

/**
 * Q4. Nested try blocks
 * Inner try : access an array element.
 * Outer try : divide two numbers.
 * Separate catch blocks handle each kind of error.
 */
class NestedOperations {
    private final int[] arr = {5, 10, 15};

    void perform(int index, int numerator, int denominator) {
        try {
            // ----- Outer try: division -----
            System.out.println("Outer try: dividing " + numerator + " by " + denominator);

            try {
                // ----- Inner try: array access -----
                System.out.println("Inner try: accessing arr[" + index + "]");
                System.out.println("Element = " + arr[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Invalid array index -> " + e.getMessage());
            }

            System.out.println("Division result = " + (numerator / denominator));
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Division by zero -> " + e.getMessage());
        }
    }
}

public class Q04_NestedTry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array index (array has 3 elements): ");
        int index = sc.nextInt();
        System.out.print("Enter numerator: ");
        int n = sc.nextInt();
        System.out.print("Enter denominator: ");
        int d = sc.nextInt();

        new NestedOperations().perform(index, n, d);
        sc.close();
    }
}
