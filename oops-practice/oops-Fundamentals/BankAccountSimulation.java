class BankAccount {
    String accountNumber;
    String holder;
    double balance;
    static int totalAccounts;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holder + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds for " + holder + ".");
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew " + amount + ". New balance: " + balance);
        }
    }

    public void getStatement() {
        System.out.println("Account: " + accountNumber + ", Holder: " + holder + ", Balance: " + balance);
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new BankAccount("A001", "Ravi", 1000),
            new BankAccount("A002", "Mira", 1500),
            new BankAccount("A003", "Nikhil", 2000)
        };

        for (BankAccount account : accounts) {
            for (int i = 1; i <= 5; i++) {
                if (i % 2 == 0) {
                    account.deposit(100 * i);
                } else {
                    account.withdraw(50 * i);
                }
            }
            account.getStatement();
            System.out.println();
        }

        System.out.println("Total accounts created: " + BankAccount.totalAccounts);
    }
}
