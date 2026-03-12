package task_7;

public class BankAccount implements BankAccountOperations {

    double balance = 0;

    public BankAccount(double balance) {
        this.balance+=balance;
    }
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance+=amount;
        } else {
            System.err.println("Нельзя внести отрицательную сумму");
        }
    }
    @Override
    public void withdraw(double amount) {
        if ((amount > balance) & (amount > 0)) {
            System.err.println("Нет столько денег на счету");
        } else {
            balance-=amount;
        }
    } 
}
