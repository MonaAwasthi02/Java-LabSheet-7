/** Advance Q1: create a thread by extending the Thread class; print a message 5 times. */
class MessageThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Message " + i + ": Hello from thread " + getName());
        }
    }
}

public class T01_ThreadExtend {
    public static void main(String[] args) {
        MessageThread t = new MessageThread();
        t.start(); // start() creates a new thread and calls run()
    }
}
