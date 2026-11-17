/**
 * Q5. finally block demonstration
 * A resource is opened, used, and "Resource closed" is ALWAYS printed
 * from the finally block, even when an exception occurs.
 */
class Resource {
    void open() {
        System.out.println("File opened");
    }

    void operate(boolean causeError) {
        System.out.println("Performing operation...");
        if (causeError) {
            int x = 10 / 0; // forces an ArithmeticException
            System.out.println(x); // never reached
        }
        System.out.println("Operation completed successfully.");
    }

    void close() {
        System.out.println("Resource closed");
    }
}

public class Q05_FinallyBlock {
    static void run(boolean causeError) {
        Resource r = new Resource();
        try {
            r.open();
            r.operate(causeError);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            r.close(); // always executed
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Run 1: without exception ---");
        run(false);

        System.out.println("\n--- Run 2: with exception ---");
        run(true);
    }
}
