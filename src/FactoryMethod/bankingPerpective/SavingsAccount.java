package FactoryMethod.bankingPerpective;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String bankName, String accountNumber, double balance) {
        super(bankName, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + " from savings account.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited " + amount + " into savings account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
