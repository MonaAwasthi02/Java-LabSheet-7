/**
 * Advance Q3: life cycle of a thread.
 *
 * States shown (Java's Thread.State):
 *   NEW           - thread object created, start() not yet called
 *   RUNNABLE      - after start(); ready to run / running ("Running" in the lab sheet)
 *   TIMED_WAITING - sleeping (a waiting state)
 *   BLOCKED       - waiting to acquire a monitor lock held by another thread
 *   TERMINATED    - run() has finished
 */
class SleepingTask extends Thread {
    @Override
    public void run() {
        System.out.println("  [Worker] running, state = " + getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("  [Worker] finished work");
    }
}

class LockTask extends Thread {
    private final Object lock;

    LockTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("  [LockTask] got the lock");
        }
    }
}

public class T03_ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Demo 1: NEW -> RUNNABLE -> TIMED_WAITING -> TERMINATED ===");
        SleepingTask t = new SleepingTask();
        System.out.println("1. After creation        : " + t.getState());  // NEW

        t.start();
        System.out.println("2. After start()         : " + t.getState());  // RUNNABLE

        Thread.sleep(100);
        System.out.println("3. While worker sleeping : " + t.getState());  // TIMED_WAITING

        t.join();
        System.out.println("4. After completion      : " + t.getState());  // TERMINATED

        System.out.println("\n=== Demo 2: BLOCKED ===");
        Object lock = new Object();
        LockTask blocked = new LockTask(lock);
        synchronized (lock) {           // main holds the lock
            blocked.start();
            Thread.sleep(200);          // give blocked thread time to try for the lock
            System.out.println("5. Waiting for lock held by main: " + blocked.getState()); // BLOCKED
        }                               // lock released here
        blocked.join();
        System.out.println("6. After completion      : " + blocked.getState());  // TERMINATED
    }
}
