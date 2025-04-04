public class Account {
  private double balance;

  // constructor to start with custom starting balance (might go unused)
  public Account(double balance) {
    this.balance = balance;
  }

  // default constructor
  public Account() {
    balance = 1000;
  }
}
