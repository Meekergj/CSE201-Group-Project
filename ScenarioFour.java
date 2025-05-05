import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: ScenarioFour
 * @author: Andrew Finkelmeier
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 * 
 * Purpose: Provides the methods which will be randomly selected at the beginning of the fourth scenario. 
 */
public class ScenarioFour {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int randomNumber = rand.nextInt(3) + 1;

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;

  public ScenarioFour(GameFunctions gameFunction) {
    this.gameFunction = gameFunction;
    this.employees = gameFunction.getEmployees();
    this.account = gameFunction.getAccount();
    this.stockPortfolio = gameFunction.getPortfolio();
  }

    public void startScenarioFour() {
        switch (randomNumber) {
            case 1 -> {
                System.out.println("Quarter Four: You have a choice to make!");
                girlfriendBreakupStart();
            }
            case 2 -> {
                System.out.println("Quarter Four: A different path awaits you!");
                marketCollapseStart();
                // Logic for another option can be added here
            }
            case 3 -> {
                System.out.println("Quarter Four: A surprise event occurs!");
                rivalMercenariesStart();
                // Logic for a surprise event can be added here
            }
            default -> System.out.println("Unexpected scenario number.");
        }

        // Add dialogue or logic for the chosen scenario here, or starting the next
        // room or quarter in the game.

    }

    public void girlfriendBreakupStart() {
        System.out.println("Your girlfriend dumped you out of nowhere and you're pretty maaaaaddd.");
        System.out.println("Type 1 to crashout on your employees or 2 to impulse buy a boat: ");
        girlfriendBreakup();
    }
    
    public void girlfriendBreakup() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().changeMorale(-10); //decreases employee morale by 10
        }
        else if(choice.equals("2")) {
            gameFunction.getAccount().updateBalance(-1000); //withdraws all money from account
        }
        else {
            System.out.println("You're too distraught to do anything else, choose again: ");
            girlfriendBreakup();
        }
    }

    public void marketCollapseStart() {
        System.out.println("The stock market is on fire! This could be the Great Incineration they've talked about!");
        System.out.println("Type 1 to liquidate everything, fire all employees, and take what you can or 2 to stick with the program: ");
        marketCollapse();
    }

    public void marketCollapse() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().setEmployeeCount(0); //fires all employees
            gameFunction.getEmployees().changeMorale(0); //decreases employee morale by 10
            for (Stock s : stockPortfolio) {
                s.sellShares(s.getSharesOwned()); //deactivates all stocks in the list
            }
            gameFunction.gameCommence();
        }
        else if(choice.equals("2")) {
            gameFunction.startCollapse(); //separate method that decreases stock value at beginning of each month
        }
        else {
            System.out.println("Is it hot in here to anyone else? I can't think straight. CHOOSE AGAIN: ");
            marketCollapse();
        }
    }

    public void rivalMercenariesStart() {
        System.out.println("A rival stock investor sent some unwanted company to sabotage you.");
        System.out.println("Type 1 to escort your employees out safely or 2 to stand your ground and fight: ");
        rivalMercenaries();
    }

    public void rivalMercenaries() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().changeMorale(2.5); //fires all employees

            for(int i = 0; i < 3; i++) {
                gameFunction.deactivateStock(i); //deactivates first 3 stocks in the list
            }
        }
        else if(choice.equals("2")) {
            gameFunction.getAccount().updateBalance(-750); //alt method that withdraws all money from account
        }
        else {
            System.out.println("You really feel the need to be a hero here, choose again: ");
            rivalMercenaries();
        }
    }
}
