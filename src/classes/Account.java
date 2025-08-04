package classes;

import util.IDGenerator;

public class Account {

    private String id;
    private int pin;
    private Customer owner;
    private double balance;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
        this(0000, new Customer(), 0);
    }

    public Account(int pin, Customer owner, double balance) {
        IDGenerator idGenerator = new IDGenerator();
        this.id = idGenerator.calculateID();
        this.pin = pin;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new RuntimeException("Deposit failed!");
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || this.balance <= 0) throw new RuntimeException("Withdrawal failed!");
        this.balance -= amount;
    }

    public void transfer(Account target, double amount) {
        if (target == null || amount <= 0 || this.balance <= 0 || target.getBalance() <= 0)
            throw new RuntimeException("Transfer failed!");

        this.balance -= amount;
        target.setBalance(target.getBalance() + amount);
    }

    @Override
    public String toString() {
        return "Account: {id:" + this.id + ", pin:" + this.pin + ", owner:" + this.owner.getName() + ", balance:" + this.balance + "}";
    }
}
