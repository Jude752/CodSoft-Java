import java.util.Scanner;

// Class to represent a bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Getter method to retrieve the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account, returns true if successful, false otherwise
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Unable to withdraw.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

// Class to represent the ATM
class ATM {
    private BankAccount userAccount;

    // Constructor to link the ATM with a user's bank account
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to perform a transaction based on the user's choice
    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
}

// Main class to run the ATM system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        // Create a user's bank account
        BankAccount userAccount = new BankAccount(initialBalance);
        // Create an ATM linked to the user's account
        ATM atm = new ATM(userAccount);

        // Main loop for interacting with the ATM
        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(choice, scanner);
        }
    }
}
