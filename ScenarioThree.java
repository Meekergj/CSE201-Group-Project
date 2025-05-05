import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScenarioThree {

  Random rand = new Random();
  int randomNumber = rand.nextInt(3) + 1;

  private GameFunctions gameFunction;
  private Account account;
  private List<Stock> stockPortfolio;
  private Employees employees;

  public ScenarioThree(GameFunctions gameFunction) {
      this.gameFunction = gameFunction;
      this.employees = gameFunction.getEmployees();
      this.account = gameFunction.getAccount();
      this.stockPortfolio = gameFunction.getPortfolio();
  }

  public void startScenarioThree() {
    switch (randomNumber) {
        case 1 -> {
            System.out.println("Scenario 3: You have a choice to make!");
            batemanEvent();
          }
        case 2 -> {
            System.out.println("Scenario 3: A different path awaits you!");
            carCrash();
            // Logic for another option can be added here
        }
        case 3 -> {
            System.out.println("Scenario 3: A surprise event occurs!");
            bullishTrend();
            // Logic for a surprise event can be added here
        }
        default -> System.out.println("Unexpected scenario number.");
    }

    // Add dialogue or logic for the chosen scenario here, or starting the next
    // room or quarter in the game.

}
  

  public void batemanEvent() {
    // i could prolly make this one print statement but ill figure that out later
    System.out.println("Bahhtrick Bateman has mauled an employee of yours");
    System.out.println("and they are now in critical condition. Type 1 to");
    System.out.println("pay to get them the best doctors OR type 2 to forget");
    System.out.println("about them and hire Bateman instead.");

    Scanner scan = new Scanner(System.in);
    
    System.out.print("> \n");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") { // Pay for health
        System.out.println("Your employee made a swift recovery! (-$500)");
        gameFunction.getAccount().updateBalance(-500);
      } else if (choice == "2") {

        // Add an employee to the array
        gameFunction.getEmployees().changeProductivity(-30);

      } else {
        System.out.println("Is it hot in here to anyone else? I can't think straight. CHOOSE AGAIN: ");
        batemanEvent();
      }
    }
  }

  // I changed this scenario a bit from the proposal but the effects it has are
  // the same
  public void carCrash() {
    System.out.println("You accidentally pulled out in front of a single");
    System.out.println("mother's minivan and caused an impact. It caused you");
    System.out.println("some injury. Type 1 to get out of your car and deal");
    System.out.println("with the consequences or type 2 to drive away and");
    System.out.println("act like nothing happened");

    Scanner scan = new Scanner(System.in);

    System.out.print("> \n");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") {
        System.out.println("You pay the mother enough money to cover the ");
        System.out.print("damages and keep quiet. (-$2000)");

        gameFunction.getAccount().updateBalance(2000);
      } else if (choice == "2") {
        System.out.println("There was a witness at the scene and word got");
        System.out.print("around to your employees.");
        gameFunction.getEmployees().changeProductivity(-10);
      }
    }
  }

  public void bullishTrend() {
    System.out.println("A stock in your portfolio becomes is now super trendy");
    System.out.println("now. Type 1 to sell off some of your stake or type 2");
    System.out.println("to buy even more!");
    // Give them option to buy amount of stock shares
    // Maybe display the price of the stock at the time of the transaction and total
    Scanner scan = new Scanner(System.in);

    System.out.print("> \n");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") {
        // Update to use shares from Stock class if 
        gameFunction.getAccount().updateBalance(2000);
      } else if (choice == "2") {
        gameFunction.getAccount().updateBalance(-2000);
      }
    }
  }
}
