abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("SA1001");
        savingsAccount.setHolderName("Priya Patel");
        savingsAccount.setBalance(50000);
        savingsAccount.setInterestRate(4.5);

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber("CA2001");
        currentAccount.setHolderName("Manish Rao");
        currentAccount.setBalance(30000);
        currentAccount.setMonthlyBonusRate(1.2);

        savingsAccount.deposit(10000);
        savingsAccount.withdraw(5000);

        currentAccount.deposit(5000);
        currentAccount.withdraw(2000);

        System.out.println("Savings Account Details");
        savingsAccount.displayAccountDetails();
        System.out.println("Interest: " + savingsAccount.calculateInterest());
        System.out.println();

        System.out.println("Current Account Details");
        currentAccount.displayAccountDetails();
        System.out.println("Interest: " + currentAccount.calculateInterest());
    }
}
