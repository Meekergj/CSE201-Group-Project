public class Account {
  private double balance;
  private String name;
  private double mostRecentChange;
  

  // constructor to start with custom starting balance (might go unused)
  public Account(double defaultBalance, String name) {
    this.balance = defaultBalance;
    this.name = name;
  }

  // default constructor
  public Account() {
    balance = 1000;
    name = "Default Account Holder";
  }

  public String getName() {
    return name;
  }

  public void setName(String accountHolder) {
    this.name = accountHolder;
  }

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

  public double getBalance() {
    return balance;
  }

  public String updateBalance(double depositOrWithdraw) {
    balance += depositOrWithdraw;
    mostRecentChange = depositOrWithdraw;
    return ("Most recent change in your account was $" + depositOrWithdraw + ". New balance is $" + balance);
  }

  public void displayBalance() {
    System.out.printf("Current balance: $%.2f%n (Change: $%.2f)\n", balance, mostRecentChange);
  }
}
