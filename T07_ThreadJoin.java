/**
 * Advance Q7: one thread waits for another to finish using join().
 *
 * The main thread starts "first", then calls first.join() so it waits until the
 * first thread terminates before starting the second thread.
 */
class TaskThread extends Thread {
    TaskThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " : step " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " : completed");
    }
}

public class T07_ThreadJoin {
    public static void main(String[] args) {
        TaskThread first  = new TaskThread("First-Thread");
        TaskThread second = new TaskThread("Second-Thread");

        first.start();
        try {
            first.join(); // main waits here until First-Thread finishes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("First thread finished, now starting second thread...");
        second.start();
    }
}
