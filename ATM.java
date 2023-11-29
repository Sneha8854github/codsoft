package demo;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATM {
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        int attempts = 0;

        while (true) {
            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Maximum number of attempts reached. Exiting.");
                break;
            }

            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    performWithdrawal(scanner, userAccount);
                    break;
                case 2:
                    performDeposit(scanner, userAccount);
                    break;
                case 3:
                    displayBalance(userAccount);
                    break;
                case 4:
                    exitProgram(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

            attempts++;
        }
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void performWithdrawal(Scanner scanner, BankAccount userAccount) {
        System.out.print("Enter the amount to withdraw: ");
        double withdrawAmount = getValidAmount(scanner);

        if (userAccount.withdraw(withdrawAmount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    private static void performDeposit(Scanner scanner, BankAccount userAccount) {
        System.out.print("Enter the amount to deposit: ");
        double depositAmount = getValidAmount(scanner);

        userAccount.deposit(depositAmount);
        System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
    }

    private static void displayBalance(BankAccount userAccount) {
        System.out.println("Current Balance: " + userAccount.getBalance());
    }

    private static void exitProgram(Scanner scanner) {
        System.out.println("Thank you for using the ATM. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    private static double getValidAmount(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            System.out.print("Enter the amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

