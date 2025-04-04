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
    changeInBalance = changeMoney;
  }

  public double getChangeInMoney() {
    return changeInBalance;
  }
}
