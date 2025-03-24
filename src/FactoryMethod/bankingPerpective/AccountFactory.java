package FactoryMethod.bankingPerpective;

import java.util.Map;

public class AccountFactory {
    public static BankAccount createAccount(AccountType type, String bankName, String accountNumber, double balance, Map<String,Object> params){
        switch (type) {
            case SAVINGS:
                return new SavingsAccount(bankName, accountNumber, balance);
            case CHECKING:
                return new CheckingAccount(bankName, accountNumber, balance);
            case FIXED_DEPOSIT:
                if (params == null || !params.containsKey("tenureInYears")) {
                    throw new IllegalArgumentException("Tenure in years is required for fixed deposit account.");
                }
                Integer tenure = (Integer) params.get("tenureInYears");
                return new FixedDepositAccount(bankName, accountNumber, balance, tenure);
            case LOAN:
                if (params == null || !params.containsKey("interestRate")) {
                    throw new IllegalArgumentException("Interest rate is required for loan account.");
                }
                Double interestRate = (Double) params.get("interestRate");
                return new LoanAccount(bankName, accountNumber, balance, interestRate);
            default:
                throw new UnsupportedOperationException("Unsupported account type.");
        }
    }
}
