public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && balance >= amt) {
            balance -= amt;
            return true;
        }
        return false;
    }
}
