package FactoryMethod.bankingPerpective;


public abstract class BankAccount {
    private String bankName;
    private String accountNumber;
    private double balance;

    public BankAccount(String bankName, String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
