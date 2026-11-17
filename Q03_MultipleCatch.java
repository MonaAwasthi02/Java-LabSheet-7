import java.util.Scanner;

/**
 * Q3. Multiple catch blocks
 * Accept two numbers as strings, convert to integers and divide.
 * Handle NumberFormatException and ArithmeticException separately.
 */
class StringDivider {
    private final String first;
    private final String second;

    StringDivider(String first, String second) {
        this.first = first;
        this.second = second;
    }

    int divide() {
        int a = Integer.parseInt(first);   // may throw NumberFormatException
        int b = Integer.parseInt(second);  // may throw NumberFormatException
        return a / b;                      // may throw ArithmeticException
    }
}

public class Q03_MultipleCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        String s1 = sc.next();
        System.out.print("Enter second number: ");
        String s2 = sc.next();

        try {
            StringDivider d = new StringDivider(s1, s2);
            System.out.println("Result = " + d.divide());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Input is not a valid integer -> " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero is not allowed -> " + e.getMessage());
        }
        sc.close();
    }
}
