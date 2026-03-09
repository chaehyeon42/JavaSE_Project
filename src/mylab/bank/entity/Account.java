package mylab.bank.entity;
import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    // 출금 기능 (추상 메서드 혹은 공통 메서드로 구현 가능, 여기서는 공통 로직 처리)
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        this.balance -= amount;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    
    @Override
    public abstract String toString();
}