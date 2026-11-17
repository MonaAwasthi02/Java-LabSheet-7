import demo.AccessDemo;

/**
 * Intermediate Q5: test which members are accessible from OUTSIDE package "demo"
 * (and without inheritance).
 *
 * Result:
 *   public     -> accessible
 *   protected  -> NOT accessible (only same package or subclasses)
 *   default    -> NOT accessible (only same package)
 *   private    -> NOT accessible (only same class)
 */
public class Q05_AccessTest {
    public static void main(String[] args) {
        AccessDemo obj = new AccessDemo();

        // Accessible
        System.out.println("publicVar = " + obj.publicVar);
        obj.publicMethod();

        // Not accessible - uncomment any line to see the compile error
        // System.out.println(obj.protectedVar);   // error: protectedVar has protected access
        // obj.protectedMethod();                  // error: protectedMethod() has protected access
        // System.out.println(obj.defaultVar);     // error: defaultVar is not public
        // obj.defaultMethod();                    // error: defaultMethod() is not public
        // System.out.println(obj.privateVar);     // error: privateVar has private access
        // obj.privateMethod();                    // error: privateMethod() has private access

        // Private data reached only through a public getter
        System.out.println("privateVar via getter = " + obj.getPrivateVar());
    }
}
