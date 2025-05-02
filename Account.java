public class Account {
  private double balance;
  private String accountHolder;
  private double mostRecentChange;
  

  // constructor to start with custom starting balance (might go unused)
  public Account(double defaultBalance, String accountHolder) {
    this.balance = defaultBalance;
    this.accountHolder = accountHolder;
  }

  // default constructor
  public Account() {
    balance = 1000;
    accountHolder = "Default Account Holder";
  }

  public String getName() {
    return accountHolder;
  }

  public void setName(String accountHolder) {
    this.accountHolder = accountHolder;
  }

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

  public double getBalance() {
    return balance;
  }

  public String updateBalance(int depositOrWithdraw) {
    balance += depositOrWithdraw;
    mostRecentChange = depositOrWithdraw;
    return ("Most recent change in your account was $" + depositOrWithdraw + ". New balance is $" + balance);
  }

  public void displayBalance() {
    System.out.printf("Current balance: $%.2f%n (Change: $%.2f)\n", balance, mostRecentChange);
  }
}
