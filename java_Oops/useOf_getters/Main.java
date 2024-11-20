import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class BankAccount{
    private String accountHolder;
    private int accountNumber;
    private double Balance;

    public BankAccount(String accountHolder, int accountNumber, double Balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.Balance = Balance;
    }

    public double getBalance() { return Balance; } // Getter for balance

    public void setBalance(int Balance){ // Setter for balance
        this.Balance = Balance;
    }
    public void deposite(double Amount){
        Balance = Balance + Amount;
    }
    public void withdraw(double Amount){
        Balance = Balance - Amount;
    }
    public void displayBalance(){
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + Balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount("John Doe", 12345, 700.0);
        bank.deposite(100.0);
        bank.displayBalance();
        bank.withdraw(50.0);
        bank.displayBalance();
    }
}