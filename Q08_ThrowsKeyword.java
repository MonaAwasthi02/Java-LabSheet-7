import java.util.Scanner;

/**
 * Q8. Using throws keyword
 * readNumber() reads input and converts it to an int.
 * It declares "throws NumberFormatException"; the CALLING method handles it.
 */
class NumberReader {
    private final Scanner sc = new Scanner(System.in);

    int readNumber() throws NumberFormatException {
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
        return Integer.parseInt(input.trim()); // may throw NumberFormatException
    }

    void close() {
        sc.close();
    }
}

public class Q08_ThrowsKeyword {
    // calling method that handles the exception
    static void processInput(NumberReader reader) {
        try {
            int n = reader.readNumber();
            System.out.println("You entered: " + n + " (square = " + (n * n) + ")");
        } catch (NumberFormatException e) {
            System.out.println("Handled in calling method -> invalid number: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NumberReader reader = new NumberReader();
        processInput(reader);
        reader.close();
    }
}
