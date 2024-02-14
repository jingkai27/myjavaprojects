class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        // Implement the withdraw method here
        if (amount > balance){
            throw new InsufficientFundsException("Insufficient funds available.");
        }
        else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class bankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(1200); // Try different withdrawal amounts
            System.out.println("Withdrawal successful. Updated balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
