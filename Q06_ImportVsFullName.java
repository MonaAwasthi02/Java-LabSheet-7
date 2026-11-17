import animals.Dog; // method (a): import statement

/**
 * Intermediate Q6: import vs fully qualified name.
 *
 * Comparison:
 *   (a) import animals.Dog;
 *       - Write "Dog" directly; code is shorter and more readable.
 *       - Best when the class is used many times.
 *   (b) animals.Dog obj = new animals.Dog();
 *       - No import needed; the full package path is written each time.
 *       - Useful when two classes with the same name come from different packages
 *         (e.g. java.util.Date and java.sql.Date), to avoid ambiguity.
 *   Both produce exactly the same result at runtime.
 */
public class Q06_ImportVsFullName {
    public static void main(String[] args) {
        // (a) using import
        Dog d1 = new Dog();
        d1.bark();

        // (b) using fully qualified name
        animals.Dog d2 = new animals.Dog();
        d2.bark();
    }
}
