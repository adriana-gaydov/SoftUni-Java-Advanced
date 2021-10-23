package BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int nextAccountID = 1;

    public BankAccount(double balance) {
        this.id = nextAccountID++;
        this.balance = balance;
    }

    public BankAccount() {
        this(0);
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        balance += amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static int getNextAccountID() {
        return nextAccountID;
    }
}
