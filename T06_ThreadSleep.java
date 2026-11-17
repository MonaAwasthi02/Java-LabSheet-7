/**
 * Advance Q6: one thread sleeps for 2 seconds, another continues execution.
 *
 * Explanation:
 *   Thread.sleep() pauses ONLY the thread that calls it (it goes into TIMED_WAITING and
 *   releases the CPU, but does not release any locks it holds). Other threads are not
 *   affected, so the worker keeps printing while the sleeper is asleep.
 */
class SleeperThread extends Thread {
    @Override
    public void run() {
        System.out.println("Sleeper: going to sleep for 2 seconds...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleeper: woke up!");
    }
}

class WorkerThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Worker: working... step " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker: done");
    }
}

public class T06_ThreadSleep {
    public static void main(String[] args) {
        new SleeperThread().start();
        new WorkerThread().start();
    }
}
