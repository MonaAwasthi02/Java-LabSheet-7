/** Advance Q2: create a thread by implementing Runnable; display numbers 1 to 10. */
class NumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
        }
    }
}

public class T02_RunnableInterface {
    public static void main(String[] args) {
        Thread t = new Thread(new NumberPrinter());
        t.start();
    }
}
