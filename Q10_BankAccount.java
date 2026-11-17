import java.util.Scanner;

/**
 * Q10. Banking example - user-defined + built-in exceptions
 * withdraw(amount):
 *   amount > balance -> InsufficientFundsException (user-defined)
 *   amount < 0       -> IllegalArgumentException  (built-in)
 */
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Balance = " + balance
                    + ", requested = " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance = " + balance);
    }
}

public class Q10_BankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        Scanner sc = new Scanner(System.in);

        System.out.println("Current balance: " + account.getBalance());
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        sc.close();
    }
}
