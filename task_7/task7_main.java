package task_7;

public class task7_main {
    public static void main(String[] args) {
        BankAccountOperations account1 = new BankAccount(1000.0);
        BankAccountOperations account2 = new BankAccount(500.0);

        System.out.println("Начальные балансы:");
        System.out.println("Счёт 1: " + account1.getBalance());
        System.out.println("Счёт 2: " + account2.getBalance());

        System.out.println("\nВносим 500 на счёт 1:");
        account1.deposit(500.0);
        System.out.println("Счёт 1: " + account1.getBalance());

        System.out.println("\nСнимаем 200 со счёта 2:");
        account2.withdraw(200.0);
        System.out.println("Счёт 2: " + account2.getBalance());

        System.out.println("\nПопытка снять больше, чем есть на счёте 2:");
        account2.withdraw(500.0);
        System.out.println("Счёт 2: " + account2.getBalance());

        System.out.println("\nВносим 1000 на счёт 2:");
        account2.deposit(1000.0);
        System.out.println("Счёт 2: " + account2.getBalance());
    }
}
