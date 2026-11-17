import java.util.ArrayList;
import java.util.Scanner;

/**
 * Intermediate Q8: using the built-in package java.util.
 * System packages are imported exactly like user-defined ones.
 * (java.lang, e.g. String and System, is imported automatically.)
 */
public class Q08_JavaUtilPackage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("How many names do you want to enter? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name " + i + ": ");
            names.add(sc.nextLine());
        }

        System.out.println("\nNames stored in ArrayList:");
        for (String s : names) {
            System.out.println(" - " + s);
        }
        System.out.println("Total names: " + names.size());
        sc.close();
    }
}
