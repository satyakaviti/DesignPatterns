package FactoryMethod.bankingPerpective;

public class LoanAccount extends BankAccount {
    private double interestRate;

    public LoanAccount(String bankName, String accountNumber, double balance, double interestRate) {
        super(bankName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Disbursed " + amount + " to loan account.");
        } else {
            System.out.println("Invalid disbursement amount.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Repaid " + amount + " from loan account.");
        } else {
            System.out.println("Invalid repayment amount.");
        }
    }

    public double getInterestRate() {
        return interestRate;
    }
}
