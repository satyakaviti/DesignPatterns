package FactoryMethod.bankingPerpective;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Get account type from user
            AccountType accountType = getAccountType(sc);

            // Get basic account details
            System.out.println("Enter bank name:");
            String bankName = sc.nextLine();

            System.out.println("Enter account number:");
            String accountNumber = sc.nextLine();

            System.out.println("Enter initial balance:");
            double balance = getValidDouble(sc, "Invalid balance. Please enter a valid number:");

            // Get additional parameters for specific account types
            Map<String, Object> params = getAdditionalParameters(sc, accountType);

            try {
                // Create the account
                BankAccount account = AccountFactory.createAccount(accountType, bankName, accountNumber, balance, params);
                displayAccountDetails(account);

                // Handle transactions
                if (confirm(sc, "Do you want to perform a transaction? (yes/no):")) {
                    performTransaction(sc, account);
                }

            } catch (Exception e) {
                System.out.println("Error creating account: " + e.getMessage());
            }
        }
    }

    private static AccountType getAccountType(Scanner sc) {
        while (true) {
            System.out.println("Enter account type (SAVINGS, CHECKING, FIXED_DEPOSIT, LOAN):");
            try {
                return AccountType.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid account type. Please enter a valid type.");
            }
        }
    }

    private static double getValidDouble(Scanner sc, String errorMessage) {
        while (!sc.hasNextDouble()) {
            System.out.println(errorMessage);
            sc.next();
        }
        return sc.nextDouble();
    }

    private static Map<String, Object> getAdditionalParameters(Scanner sc, AccountType accountType) {
        Map<String, Object> params = new HashMap<>();
        switch (accountType) {
            case FIXED_DEPOSIT:
                System.out.println("Enter tenure (in years):");
                int tenure = (int) getValidDouble(sc, "Invalid tenure. Please enter a valid number:");
                params.put("tenureInYears", tenure);
                break;
            case LOAN:
                System.out.println("Enter interest rate (in percentage):");
                double interestRate = getValidDouble(sc, "Invalid interest rate. Please enter a valid number:");
                params.put("interestRate", interestRate);
                break;
            default:
                break; // No additional parameters for other account types
        }
        return params;
    }

    private static void displayAccountDetails(BankAccount account) {
        System.out.println("Account successfully created: " + account.getClass().getSimpleName());
        System.out.println("Account Details:");
        System.out.println("Bank Name: " + account.getBankName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }

    private static boolean confirm(Scanner sc, String message) {
        System.out.println(message);
        String response = sc.next().toLowerCase();
        return response.equals("yes");
    }

    private static void performTransaction(Scanner sc, BankAccount account) {
        System.out.println("Enter transaction type (deposit/withdraw):");
        String transactionType = sc.next().toLowerCase();

        System.out.println("Enter amount:");
        double amount = getValidDouble(sc, "Invalid amount. Please enter a valid number:");

        if (transactionType.equals("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equals("withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}
