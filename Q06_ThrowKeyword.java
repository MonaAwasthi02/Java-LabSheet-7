import java.util.Scanner;

/**
 * Q6. Using throw keyword
 * checkAge(int age) throws an exception if age < 18.
 * The exception is handled in main().
 */
class AgeValidator {
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age " + age + " is not allowed. You must be 18 or older.");
        }
        System.out.println("Age " + age + " is valid. Access granted.");
    }
}

public class Q06_ThrowKeyword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            AgeValidator.checkAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main(): " + e.getMessage());
        }
        sc.close();
    }
}
