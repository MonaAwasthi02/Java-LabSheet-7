import testpack.PublicClass;
// import testpack.DefaultClass;   // COMPILE ERROR: testpack.DefaultClass is not public in testpack

/**
 * Intermediate Q3: access public and default classes from another package.
 *
 * Observation:
 *   - PublicClass can be imported and used.
 *   - DefaultClass is package-private, so uncommenting the lines below gives:
 *       error: DefaultClass is not public in testpack; cannot be accessed from outside package
 */
public class Q03_TestAccess {
    public static void main(String[] args) {
        PublicClass p = new PublicClass();
        p.show();

        // DefaultClass d = new DefaultClass();   // COMPILE ERROR if uncommented
        // d.show();
        System.out.println("DefaultClass cannot be accessed outside its package (see comments in source).");
    }
}
