/**
 * Advance Q5: thread priorities.
 *
 * MIN_PRIORITY = 1, NORM_PRIORITY = 5, MAX_PRIORITY = 10.
 * Observation: a higher priority is only a HINT to the scheduler. Usually the MAX
 * priority thread tends to finish/start earlier, but the order is not guaranteed
 * and can differ between runs, JVMs and operating systems.
 */
class PriorityTask extends Thread {
    PriorityTask(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = 0; i < 50_000_000; i++) { // some CPU work
            sum += i;
        }
        System.out.println(getName() + " (priority " + getPriority() + ") finished. sum=" + sum);
    }
}

public class T05_ThreadPriority {
    public static void main(String[] args) {
        PriorityTask low  = new PriorityTask("Low-Thread",  Thread.MIN_PRIORITY);
        PriorityTask norm = new PriorityTask("Norm-Thread", Thread.NORM_PRIORITY);
        PriorityTask high = new PriorityTask("High-Thread", Thread.MAX_PRIORITY);

        low.start();
        norm.start();
        high.start();
    }
}
