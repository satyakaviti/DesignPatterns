package FactoryMethod.bankingPerpective;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String bankName, String accountNumber, double balance) {
        super(bankName, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + " from checking account.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited " + amount + " into checking account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}