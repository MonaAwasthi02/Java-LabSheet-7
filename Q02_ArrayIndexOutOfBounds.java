import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Q2. Array Index Out of Bounds
 * Create an array of 5 elements, ask for an index and display its value.
 * Handle invalid index using ArrayIndexOutOfBoundsException.
 */
class NumberArray {
    private final int[] data = {10, 20, 30, 40, 50};

    int getValueAt(int index) {
        return data[index]; // throws ArrayIndexOutOfBoundsException for invalid index
    }

    int size() {
        return data.length;
    }
}

public class Q02_ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        NumberArray array = new NumberArray();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter an index (0 to " + (array.size() - 1) + "): ");
            int index = sc.nextInt();
            System.out.println("Value at index " + index + " = " + array.getValueAt(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index! " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter an integer index.");
        } finally {
            sc.close();
        }
    }
}
