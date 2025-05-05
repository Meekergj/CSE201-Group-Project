
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * ScenarioTwo handles the events and decisions for Quarter Two of the game.
 * It presents the player with random events and allows them to make choices
 * that impact account balance and employee morale.
 * Class: ScenarioFour
 * Author: Braden Gaerke
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 *
 */
public class ScenarioTwo {
    /**
     * Generates a random event number (1-3) to determine which scenario will run.
     */
    Random rand = new Random();
    int randomNumber = rand.nextInt(3) + 1;

    private Scanner scanner;
    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;

    /**
     * Constructs a ScenarioTwo object using GameFunctions and Scanner.
     * 
     * @param gameFunction The central game logic handler.
     * @param scanner      The input scanner for player choices.
     */
    public ScenarioTwo(GameFunctions gameFunction, Scanner scanner) {
        this.scanner = scanner;
        this.gameFunction = gameFunction;
        this.employees = gameFunction.getEmployees();
        this.account = gameFunction.getAccount();
        this.stockPortfolio = gameFunction.getPortfolio();
    }

    /**
     * Starts Quarter Two and runs a randomly selected scenario based on randomNumber.
     */
    public void startScenarioTwo() {
        switch (randomNumber) {
            case 1 -> {
                System.out.println("Quarter Two: You have a choice to make!");
                optionTwo();
            }
            case 2 -> {
                System.out.println("Quarter Two: A different path awaits you!");
                optionThree();
            }
            case 3 -> {
                System.out.println("Quarter Two: A surprise event occurs!");
                optionFour();
            }
            default -> System.out.println("Unexpected scenario number.");
        }
    }

    /**
     * Option Two scenario: The player finds a wallet and chooses whether to keep the money
     * or return it to the police. Affects account balance or employee morale.
     */
    public void optionTwo() {
        System.out.println("Surprise!\n You found a wallet on the ground, it had $500 in it!" +
                "Type 1 to pick it up and keep the money\n or 2 to bring it to the police.\n");
        String playersChoice = scanner.next();
        int playersChoiceInt = -1;

        while (playersChoiceInt != 1 && playersChoiceInt != 2) {
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Try Again. Please enter a number.");
            }
            switch (playersChoiceInt) {
                case 1 -> {
                    System.out.println("Congratulations! You chose to keep the money. Your account balance has increased by $500.");
                    gameFunction.getAccount().updateBalance(500);
                }
                case 2 -> {
                    System.out.println("You chose to bring the wallet to the police. Your honesty is commendable, but you missed out on $500.");
                    gameFunction.getEmployees().changeMorale(5);
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 or 2");
                    optionTwo();
                }
            }
        }
    }

    /**
     * Option Three scenario: The player chooses whether to attend a team-building
     * event with employees. Impacts morale and account balance.
     */
    public void optionThree() {
        System.out.println("Your employees are asking you, their boss to go out with them " +
                "for a team-building event and drinks." +
                "Type 1 to join them or 2 to decline the invitation.\n");
        String playersChoice = scanner.next();
        int playersChoiceInt = -1;

        while (playersChoiceInt != 1 && playersChoiceInt != 2) {
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Try Again. Please enter a number.");
            }
            switch (playersChoiceInt) {
                case 1 -> {
                    System.out.println("You chose to join your employees for a team-building event. " +
                            "Your employees feel appreciated and their morale increases!");
                    gameFunction.getEmployees().changeMorale(10);
                    gameFunction.getAccount().updateBalance(-100);
                }
                case 2 -> {
                    System.out.println("You chose to decline the invitation. " +
                            "Your employees feel disappointed and their morale decreases.");
                    gameFunction.getEmployees().changeMorale(-10);
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe investment, or 2 for a risky investment.");
                    optionThree();
                }
            }
        }
    }

    /**
     * Option Four scenario: The player is asked for money by a homeless person.
     * Choice affects account balance or employee morale.
     */
    public void optionFour() {
        System.out.println("A homeless man is asking you for money!" +
                "Type 1 to give him $100 or 2 to ignore him.\n");
        String playersChoice = scanner.next();
        int playersChoiceInt = -1;

        while (playersChoiceInt != 1 && playersChoiceInt != 2) {
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Try Again. Please enter a number.");
            }
            switch (playersChoiceInt) {
                case 1 -> {
                    System.out.println("You chose to give him $100. Your account balance has decreased by $100.");
                    gameFunction.getAccount().updateBalance(-100);
                }
                case 2 -> {
                    System.out.println("You chose to ignore him. Your employee saw and thinks less of you.");
                    gameFunction.getEmployees().changeMorale(-5);
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe investment, or 2 for a risky investment.");
                    optionFour();
                }
            }
        }
    }
}
