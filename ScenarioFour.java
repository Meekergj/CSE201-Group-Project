import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: ScenarioFour
 * Author: Andrew Finkelmeier
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 *
 * Purpose: Provides the methods which will be randomly selected at the beginning of the fourth scenario. 
 */
public class ScenarioFour {
    Random rand = new Random();
    int randomNumber = rand.nextInt(3) + 1;

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;
    private Scanner scanner;

    /**
     * Constructor for ScenarioFour.
     * 
     * @param gameFunction Reference to the main GameFunctions object.
     * @param scanner      Scanner object for reading player input.
     */
    public ScenarioFour(GameFunctions gameFunction, Scanner scanner) {
        this.scanner = scanner;
        this.gameFunction = gameFunction;
        this.employees = gameFunction.getEmployees();
        this.account = gameFunction.getAccount();
        this.stockPortfolio = gameFunction.getPortfolio();
    }

    /**
     * Begins the fourth scenario by randomly selecting one of three events:
     * breakup, market collapse, or mercenaries.
     */
    public void startScenarioFour() {
        switch (randomNumber) {
            case 1 -> {
                System.out.println("Quarter Four: You have a choice to make!");
                girlfriendBreakupStart();
            }
            case 2 -> {
                System.out.println("Quarter Four: A different path awaits you!");
                marketCollapseStart();
            }
            case 3 -> {
                System.out.println("Quarter Four: A surprise event occurs!");
                rivalMercenariesStart();
            }
            default -> System.out.println("Unexpected scenario number.");
        }
    }

    /**
     * Starts the girlfriend breakup scenario.
     * Prompts player to choose how to react emotionally and financially.
     */
    public void girlfriendBreakupStart() {
        System.out.println("Your girlfriend dumped you out of nowhere and you're pretty maaaaaddd.");
        System.out.println("Type 1 to crashout on your employees or 2 to impulse buy a boat: ");
        girlfriendBreakup();
    }

    /**
     * Handles user decision logic for the girlfriend breakup scenario.
     */
    public void girlfriendBreakup() {
        String choice = scanner.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().changeMorale(-10);
        }
        else if(choice.equals("2")) {
            gameFunction.getAccount().updateBalance(-1000);
        }
        else {
            System.out.println("You're too distraught to do anything else, choose again: ");
            girlfriendBreakup();
        }
    }

    /**
     * Starts the market collapse scenario.
     * Offers player a decision between liquidating or holding their assets.
     */
    public void marketCollapseStart() {
        System.out.println("The stock market is on fire! This could be the Great Incineration they've talked about!");
        System.out.println("Type 1 to liquidate everything, fire all employees, and take what you can or 2 to stick with the program: ");
        marketCollapse();
    }

    /**
     * Handles user decision logic for the market collapse scenario.
     */
    public void marketCollapse() {
        String choice = scanner.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().setEmployeeCount(0);
            gameFunction.getEmployees().changeMorale(0);
            for (Stock s : stockPortfolio) {
                s.sellShares(s.getSharesOwned());
            }
            gameFunction.gameCommence();
        }
        else if(choice.equals("2")) {
            gameFunction.startCollapse();
        }
        else {
            System.out.println("Is it hot in here to anyone else? I can't think straight. CHOOSE AGAIN: ");
            marketCollapse();
        }
    }

    /**
     * Starts the rival mercenaries scenario.
     * Player chooses between evacuating staff or confronting the threat.
     */
    public void rivalMercenariesStart() {
        System.out.println("A rival stock investor sent some unwanted company to sabotage you.");
        System.out.println("Type 1 to escort your employees out safely or 2 to stand your ground and fight: ");
        rivalMercenaries();
    }

    /**
     * Handles user decision logic for the rival mercenaries scenario.
     */
    public void rivalMercenaries() {
        String choice = scanner.nextLine();

        if(choice.equals("1")) {
            gameFunction.getEmployees().changeMorale(2.5);

            for(int i = 0; i < 3; i++) {
                gameFunction.deactivateStock(i);
            }
        }
        else if(choice.equals("2")) {
            gameFunction.getAccount().updateBalance(-750);
        }
        else {
            System.out.println("You really feel the need to be a hero here, choose again: ");
            rivalMercenaries();
        }
    }
}
