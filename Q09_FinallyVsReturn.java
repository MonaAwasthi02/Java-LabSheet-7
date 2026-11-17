/**
 * Q9. Finally vs Return
 *
 * Observation / Explanation:
 *   1. The expression in "return" is evaluated FIRST (the value is stored).
 *   2. Then the finally block runs (it prints its message).
 *   3. Only after finally completes does the method actually return to the caller.
 *
 * So the "return" statement is reached first, but the finally block's code
 * executes BEFORE control leaves the method. finally therefore prints
 * its message before the caller prints the returned value.
 *
 * Note: changing a primitive in finally does NOT change the already-evaluated
 * return value (see getValue below).
 */
class ReturnTester {
    int getValue() {
        int x = 10;
        try {
            System.out.println("In try: about to return x = " + x);
            return x;           // value 10 is saved here
        } finally {
            x = 99;             // does NOT affect the returned value
            System.out.println("In finally: executed before method returns (x changed to " + x + ")");
        }
    }
}

public class Q09_FinallyVsReturn {
    public static void main(String[] args) {
        ReturnTester t = new ReturnTester();
        int result = t.getValue();
        System.out.println("In main: returned value = " + result);
    }
}
