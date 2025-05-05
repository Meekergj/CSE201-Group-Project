import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: ScenarioFour
 * Author: Baylin
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 *
 * Provides the logic for the third scenario in the game. Randomly triggers one
 * of three possible events involving a stock market trend, violent altercation,
 * or ethical dilemma.
 */
public class ScenarioThree {

  Random rand = new Random();
  int randomNumber = rand.nextInt(3) + 1;

  private GameFunctions gameFunction;
  private Account account;
  private List<Stock> stockPortfolio;
  private Employees employees;
  private Scanner scanner;

  /**
   * Constructs a ScenarioThree object with access to game state and user input.
   *
   * @param gameFunction the main game function object
   * @param scanner      the scanner for reading player input
   */
  public ScenarioThree(GameFunctions gameFunction, Scanner scanner) {
      this.scanner = scanner;
      this.gameFunction = gameFunction;
      this.employees = gameFunction.getEmployees();
      this.account = gameFunction.getAccount();
      this.stockPortfolio = gameFunction.getPortfolio();
  }

  /**
   * Starts Scenario 3 by randomly selecting one of three possible events.
   */
  public void startScenarioThree() {
    switch (randomNumber) {
        case 1 -> {
            System.out.println("Scenario 3: You have a choice to make!");
            batemanEvent();
        }
        case 2 -> {
            System.out.println("Scenario 3: A different path awaits you!");
            carCrash();
        }
        case 3 -> {
            System.out.println("Scenario 3: A surprise event occurs!");
            bullishTrend();
        }
        default -> System.out.println("Unexpected scenario number.");
    }
  }

  /**
   * Represents a scenario where a violent employee incident occurs.
   * Player must choose between helping an injured employee or hiring the attacker.
   */
  public void batemanEvent() {
    System.out.println("Bahhtrick Bateman has mauled an employee of yours");
    System.out.println("and they are now in critical condition. Type 1 to");
    System.out.println("pay to get them the best doctors OR type 2 to forget");
    System.out.println("about them and hire Bateman instead.");

    String choice = scanner.next();
    int playersChoiceInt = -1;

    while (playersChoiceInt != 1 && playersChoiceInt != 2) {
      try {
        playersChoiceInt = Integer.parseInt(choice);
      } catch (NumberFormatException e) {
        System.out.println("Try Again. Please enter a number.");
      }
      switch (playersChoiceInt) {
        case 1 -> {
          System.out.println("Your employee made a swift recovery! (-$500)");
          gameFunction.getAccount().updateBalance(-500);
        }
        case 2 -> {
          gameFunction.getEmployees().changeProductivity(-30);
          System.out.println("You hired Bahhtrick Bateman. (-$1000)");
          gameFunction.getAccount().updateBalance(-1000);
        }
        default -> {
          System.out.println("Is it hot in here to anyone else? I can't think straight. CHOOSE AGAIN: ");
          batemanEvent();
        }
      }
    }
  }

  /**
   * Represents a scenario where the player causes a car crash and must choose
   * between taking responsibility or fleeing the scene.
   */
  public void carCrash() {
    System.out.println("You accidentally pulled out in front of a single");
    System.out.println("mother's minivan and caused an impact. It caused you");
    System.out.println("some injury. Type 1 to get out of your car and deal");
    System.out.println("with the consequences or type 2 to drive away and");
    System.out.println("act like nothing happened");

    String choice = scanner.nextLine();
    int playersChoiceInt = -1;

    while (playersChoiceInt != 1 && playersChoiceInt != 2) {
      try {
        playersChoiceInt = Integer.parseInt(choice);
      } catch (NumberFormatException e) {
        System.out.println("Try Again. Please enter a number.");
      }
      if (playersChoiceInt == 1) {
        System.out.println("You pay the mother enough money to cover the ");
        System.out.print("damages and keep quiet. (-$2000)");

        gameFunction.getAccount().updateBalance(2000);
      } else if (playersChoiceInt == 2) {
        System.out.println("There was a witness at the scene and word got");
        System.out.print("around to your employees.");
        gameFunction.getEmployees().changeProductivity(-10);
      }
    }
  }

  /**
   * Represents a scenario where a stock becomes highly popular and the player
   * chooses to either sell shares for profit or invest more.
   */
  public void bullishTrend() {
    System.out.println("A stock in your portfolio becomes is now super trendy");
    System.out.println("now. Type 1 to sell off some of your stake or type 2");
    System.out.println("to buy even more!");

    String choice = scanner.nextLine();
    int playersChoiceInt = -1;

    while (playersChoiceInt != 1 && playersChoiceInt != 2) {
      try {
        playersChoiceInt = Integer.parseInt(choice);
      } catch (NumberFormatException e) {
        System.out.println("Try Again. Please enter a number.");
      }
      if (playersChoiceInt == 1) {
        gameFunction.getAccount().updateBalance(2000);
        System.out.println("You sold off some of your stake and made a profit! (+$2000)");
      } else if (playersChoiceInt == 2) {
        gameFunction.getAccount().updateBalance(-2000);
        System.out.println("You bought more shares of the stock, hoping it will continue to rise. (-$2000)");
      }
    }
  }
}
