import java.util.List;
import java.util.Scanner;

/**
 * Class: ScenarioFour
 * Author: Braden Gaerke
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 *
 * Provides the logic for the first scenario of the game where the player chooses
 * between a safe or risky investment. Based on the choice and outcome, it adjusts
 * the account balance and employee morale/productivity accordingly.
 */
public class ScenarioOne {

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;
    private Scanner scanner;

    /**
     * Constructs a ScenarioOne object using the main game logic and input scanner.
     * 
     * @param gameFunction the primary game logic controller
     * @param scanner      the Scanner for user input
     */
    public ScenarioOne(GameFunctions gameFunction, Scanner scanner) {
        this.gameFunction = gameFunction;
        this.scanner = scanner;
        this.account = gameFunction.getAccount();
        this.employees = gameFunction.getEmployees();
        this.stockPortfolio = gameFunction.getPortfolio();
    }

    /**
     * Starts the first scenario by presenting the user with a choice between a
     * safe and risky investment.
     */
    public void startScenarioOne() {
        System.out.println("Welcome! First quarter decision: \n1 = Safe Investment\n2 = Risky Investment");
        int choice = getValidChoice();
        if (choice == 1) handleSafeInvestment();
        else handleRiskyInvestment();
    }

    /**
     * Gets a valid user input choice of 1 or 2.
     * 
     * @return 1 for safe investment, 2 for risky investment
     */
    private int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.next());
                if (choice == 1 || choice == 2) return choice;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Type 1 for safe, 2 for risky.");
        }
    }

    /**
     * Handles the logic for a safe investment:
     * Adds a small profit to the user's balance and increases morale.
     */
    private void handleSafeInvestment() {
        double gain = 500 + Math.random() * 500;
        account.updateBalance(gain);
        employees.changeMorale(1.0);
        System.out.printf("Safe choice! Gained $%.2f. Morale increased.\n", gain);
    }

    /**
     * Handles the logic for a risky investment:
     * Has a 50% chance of either large profit or large loss.
     * Adjusts morale and productivity accordingly.
     */
    private void handleRiskyInvestment() {
        double roll = Math.random();
        if (roll < 0.5) {
            double loss = 1000 + Math.random() * 2000;
            account.updateBalance(-loss);
            employees.changeMorale(-1.5);
            employees.changeProductivity(-1.5);
            System.out.printf("Risk failed. Lost $%.2f. Morale & productivity decreased.\n", loss);
        } else {
            double profit = 2000 + Math.random() * 3000;
            account.updateBalance(profit);
            employees.changeMorale(2.0);
            employees.changeProductivity(2.0);
            System.out.printf("Risk paid off! Gained $%.2f. Morale & productivity increased.\n", profit);
        }
    }
}
