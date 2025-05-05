/**
 * The Account class represents a financial account with a balance and account holder name.
 * It provides functionality to view and modify the balance, track the most recent change,
 * and display account information.
 * Class : Account
 * @author: Braden Gaerke
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 */
public class Account {
  private double balance;
  private String name;
  private double mostRecentChange;

  /**
   * Constructs an Account with a custom starting balance and account holder name.
   *
   * @param defaultBalance the initial balance of the account
   * @param name           the name of the account holder
   */
  public Account(double defaultBalance, String name) {
      this.balance = defaultBalance;
      this.name = name;
  }

  /**
   * Constructs an Account with a default balance of $10,000 and a default name.
   */
  public Account() {
      balance = 10000;
      name = "Default Account Holder";
  }

  /**
   * Returns the name of the account holder.
   *
   * @return the account holder's name
   */
  public String getName() {
      return name;
  }

  /**
   * Sets the name of the account holder.
   *
   * @param accountHolder the new name for the account holder
   */
  public void setName(String accountHolder) {
      this.name = accountHolder;
  }

  /**
   * Sets the account balance to a new value.
   *
   * @param newBalance the new balance to set
   */
  public void setBalance(double newBalance) {
      this.balance = newBalance;
  }

  /**
   * Returns the current balance of the account.
   *
   * @return the account balance
   */
  public double getBalance() {
      return balance;
  }

  /**
   * Updates the account balance by depositing or withdrawing the specified amount.
   *
   * @param depositOrWithdraw the amount to deposit (positive) or withdraw (negative)
   * @return a message indicating the change and the new balance
   */
  public String updateBalance(double depositOrWithdraw) {
      balance += depositOrWithdraw;
      mostRecentChange = depositOrWithdraw;
      return ("Most recent change in your account was $" + depositOrWithdraw + ". New balance is $" + balance);
  }

  /**
   * Displays the current balance and the most recent change to the account.
   */
  public void displayBalance() {
      System.out.printf("Current balance: $%.2f%n (Change: $%.2f)%n", balance, mostRecentChange);
  }
}
