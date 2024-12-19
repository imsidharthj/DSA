import java.util.List;
import java.util.ArrayList;

public class AccountService {
    private List<Account> accounts;
    // private int accountNumberCounter = 1;

    // Constructor
    public AccountService(){
        this.accounts = new ArrayList<>();
    }

    // Method to create a new account
    public Account createAccount(String name, int pin){
        Account newAccount = new Account(name, pin);
        accounts.add(newAccount);
        System.out.println("================================");
        System.out.println("Account created successfully. Account number: " + newAccount.getAccountNumber());
        System.out.println("================================");
        System.out.println();
        return newAccount;
    }

    // Method to display all details of the account
    public void showAccountInfo(Account account) {
        System.out.println("================================");
        System.out.println("=\tAccount Number: " + account.getAccountNumber());
        System.out.println("=\tName: " + account.getName());
        System.out.println("=\tBalance: $" + account.getBalance());
        System.out.println("================================");
        System.out.println();
    }

    public double showBalance(Account account){
        return account.getBalance();
    }

    // Method to deposit funds into the account
    public void deposit(Account account, double amount){
        if(amount <= 0){ // Check if the amount to be deposited is less than or equal to 0, if so print "Invalid amount for deposit." and return
            System.out.println("Invalid amount for deposit.");
            System.out.println();
            return;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.println("=================================");
        System.out.println("Deposit successful. Updated balance: $" + account.getBalance());
        System.out.println("=================================");
        System.out.println();
    }

    // Method to withdraw funds from the account
    public void withdraw(Account account, double amount){
        if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal.");
            System.out.println();
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
            System.out.println();
            return;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("=================================");
        System.out.println("Withdrawal successful. Updated balance: $" + account.getBalance());
        System.out.println("=================================");
        System.out.println();
    }

    // Method to transfer funds from one account to another
    public void transfer(Account senderAccount, Account recipientAccount, double amount){
        if (amount <= 0) {
            System.out.println("Invalid amount for transfer.");
            System.out.println();
            return;
        }
        if (senderAccount == recipientAccount) {
            System.out.println("Sender and recipient accounts cannot be the same.");
            System.out.println();
            return;
        }
        if (senderAccount.getBalance() < amount) {
            System.out.println("Insufficient funds for transfer.");
            System.out.println();
            return;
        }
        // Deduct the transferred amount from the sender's account
        senderAccount.setBalance(senderAccount.getBalance() - amount);
    
        // Increment the recipient's account with the transferred amount
        recipientAccount.setBalance(recipientAccount.getBalance() + amount);
    
        // Print the transfer success message with the sender's updated balance
        System.out.println("=================================");
        System.out.println("Transfer successful. Updated balance: $" + senderAccount.getBalance());
        System.out.println("=================================");
        System.out.println();
    }

    // Method to get the account using account holder's name
    public Account findAccountByName(String name) {
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }
}
