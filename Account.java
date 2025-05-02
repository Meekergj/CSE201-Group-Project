public class Account {
  private double balance;
  private double changeInBalance;
  private String accountHolder;
  

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

  public void setChangeInMoney(double changeMoney) {
    this.changeInBalance = changeMoney;
  }

  public double getChangeInMoney() {
    return changeInBalance;
  }

  public void updateBalance() {
    balance += changeInBalance;
    changeInBalance = 0; // Reset change after updating balance
  }
  
  public void adjustBalance(double amount) {
    this.changeInBalance += amount;
    updateBalance(); // Update balance immediately after adjustment
  }

  public void displayBalance() {
    System.out.printf("Current balance: $%.2f%n (Change: $%.2f)\n", balance, changeInBalance);
  }
}
