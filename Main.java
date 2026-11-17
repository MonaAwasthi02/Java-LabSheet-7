package college.students;

/**
 * Intermediate Q10: main program in a separate file.
 *
 * Command-line steps (run from the 02_packages folder):
 *   javac -d . college/students/Student.java college/students/Main.java
 *   java college.students.Main
 *
 * (For a fresh Student.java in any folder: javac -d . Student.java creates the
 *  college/students/ directory automatically and puts Student.class inside it.)
 */
public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "Vidhi");
        s.display();
    }
}
