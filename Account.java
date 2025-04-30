public class Account {
  private double balance;
  private double changeInBalance;
  

  // constructor to start with custom starting balance (might go unused)
  public Account(double balance) {
    this.balance = balance;
  }

  // default constructor
  public Account() {
    balance = 1000;
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
