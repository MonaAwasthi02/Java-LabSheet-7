/**
 * Advance Q8: multiple threads access a shared counter WITHOUT synchronization.
 *
 * counter++ is not atomic (read -> add -> write). When two threads interleave
 * these steps, some increments are lost (a race condition), so the final value
 * is usually LESS than the expected 200000 and changes from run to run.
 */
class Counter {
    private int count = 0;

    void increment() {
        count++; // not thread-safe
    }

    int getCount() {
        return count;
    }
}

class IncrementTask extends Thread {
    private final Counter counter;

    IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
    }
}

public class T08_UnsyncCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementTask t1 = new IncrementTask(counter);
        IncrementTask t2 = new IncrementTask(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected count : 200000");
        System.out.println("Actual count   : " + counter.getCount() + "  (incorrect due to race condition)");
    }
}
