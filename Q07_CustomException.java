import java.util.Scanner;

/**
 * Q7. Creating User-Defined Exception (Custom)
 * InvalidPasswordException is thrown when password length < 6.
 */
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class PasswordValidator {
    void validate(String password) throws InvalidPasswordException {
        if (password.length() < 6) {
            throw new InvalidPasswordException("Password must have at least 6 characters (entered: "
                    + password.length() + ").");
        }
        System.out.println("Password accepted.");
    }
}

public class Q07_CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        PasswordValidator validator = new PasswordValidator();
        try {
            validator.validate(password);
        } catch (InvalidPasswordException e) {
            System.out.println("InvalidPasswordException: " + e.getMessage());
        }
        sc.close();
    }
}
