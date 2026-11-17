/**
 * Advance Q4: two threads run simultaneously and print their own names.
 *
 * Explanation of thread scheduling:
 *   The JVM hands thread scheduling to the operating system's scheduler. Both threads
 *   are RUNNABLE and the scheduler decides, using time-slicing and priorities, which one
 *   gets the CPU at any moment. Therefore the output order is NOT fixed - lines from
 *   Thread-A and Thread-B may interleave differently on every run.
 */
class NameThread extends Thread {
    NameThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Running: " + Thread.currentThread().getName() + " (iteration " + i + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class T04_TwoThreadsNames {
    public static void main(String[] args) {
        NameThread t1 = new NameThread("Thread-A");
        NameThread t2 = new NameThread("Thread-B");
        t1.start();
        t2.start();
    }
}
