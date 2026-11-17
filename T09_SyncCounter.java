/**
 * Advance Q9: same shared counter, now using a synchronized method.
 *
 * synchronized lets only ONE thread execute increment() at a time (it acquires the
 * object's monitor lock), so no update is lost and the result is always correct.
 */
class SafeCounter {
    private int count = 0;

    synchronized void increment() { // only one thread at a time
        count++;
    }

    int getCount() {
        return count;
    }
}

class SafeIncrementTask extends Thread {
    private final SafeCounter counter;

    SafeIncrementTask(SafeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
    }
}

public class T09_SyncCounter {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        SafeIncrementTask t1 = new SafeIncrementTask(counter);
        SafeIncrementTask t2 = new SafeIncrementTask(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected count : 200000");
        System.out.println("Actual count   : " + counter.getCount() + "  (correct thanks to synchronized)");
    }
}
