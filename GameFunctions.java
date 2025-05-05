import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class: GameFunctions
 * @author: Andrew Finkelmeier
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/4/2025
 * 
 * Purpose: Runs functions that set up the game and give opening information about how it works. Does not include mechanics. 
 */
public class GameFunctions {

    private Account account = new Account(); // Default account with initial balance
    private Employees employees = new Employees(); // Default employees
    private List<Stock> portfolio = new ArrayList<>(); // Default empty portfolio
    private int currentQuarter;
    private boolean gameOver = false;

    // Do we need setters for these 
    public GameFunctions(Account account, Employees employees, List<Stock> portfolio) {
        this.account = account;
        this.employees = employees;
        this.portfolio = portfolio;
        this.currentQuarter = 1;
    }

    public GameFunctions() {
        this.account.setName("Default Player");
        this.currentQuarter = 0; // Initialize currentQuarter to 0
    }

    public void displayStats() {
        System.out.println("\n========= GAME STATS =========");
        System.out.println("Player Name: " + account.getName());
        System.out.println("Account Balance: $" + account.getBalance());
        System.out.println("Current Quarter: " + currentQuarter);
        System.out.println("Employee Morale: " + employees.getMoral());
        System.out.println("Employee Productivity: " + employees.getProductivity());
        System.out.println("Stock Portfolio:");
    
        if (portfolio.isEmpty()) {
            System.out.println("  (No stocks owned)");
        } else {
            for (Stock stock : portfolio) {
                System.out.println("  - " + stock.getCompanyName() + " | Shares Owned: " + stock.getSharesOwned() + " | Value: $" + stock.getValue());
            }
        }
        System.out.println("================================\n");
    }
    

    public void increaseQuarter() {
        this.currentQuarter++;
    }   

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public void setPortfolio(List<Stock> portfolio) {
        this.portfolio = portfolio;
        }

        public Account getAccount() { return this.account; }
        public Employees getEmployees() { return this.employees; }
        public List<Stock> getPortfolio() { return this.portfolio; }

    public int getCurrentQuarter() {
        return currentQuarter;
    }   

    /**
     * Gives the player an introduction to the game setting.
     */
    public void gameIntro() {
        System.out.println("Initializing game...");
        System.out.println("The Wolf of Wool Street");
        System.out.println("-------------------------------------------" + "\n");

        
        System.out.println("Welcome to Wool Street newbie. Name's Woolfort.");
        System.out.println("If you want to make it around here there's only one thing you have to worry about.");
        System.out.println("GETTING SILLY RICH!");
        System.out.println("So throw your morals out the window and should you every feel SHEEPISH, just remember: you'll be the one living in ");
        System.out.println("the penhouse soon.");
        System.out.println("Remember, it's better to be the wolf than to cry wolf. Got it?");
        System.out.println("Oh and when you make it to the top, don't feel bad for your sheeple employees. ");
        System.out.print("I'd rather be bahhhtty and a millionaire than working a 9-5 at Macdonald's or Shears.");
        System.out.println("Right, you forgot to mention your name...");

        System.out.println("-------------------------------------------" + "\n");
        
        setPlayerName();
    }

    /**
     * Sets the player's name when prompted.
     */
    private String playerName;

    public void setPlayerName() {
        Scanner playerScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        this.playerName = playerScanner.nextLine();

        System.out.println("Great. Let's get you to the top " + playerName + "!");
        Account newAccount = new Account(1000, playerName);
        this.setAccount(newAccount);
    }

    public void inbetweenFirstScenario() {
        System.out.println("Before we get started, let's go over some basics.");
        System.out.println("You start with a balance of $1000.00 and your goal is to increase your wealth by making smart investments.");
        System.out.println("Each quarter, you'll face different scenarios that will test your investment skills.");
        System.out.println("Make choices wisely, as they will affect your balance and the outcome of the game.");
        System.out.println("Remember, you can go bankrupt if your balance drops to $0.00 or below.");
        System.out.println("Good luck, " + this.getAccount().getName() + "! Let's get started!");
    }

    /**
     * Asks the player if they are ready to begin and calls the gameCommence method if yes.
     * If no, the game starts anyways because that's just Wool Street for you.
     */
    public void startGame() {
        System.out.println("Ready to begin? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().toLowerCase();

        if(response.equals("yes")) {
            System.out.println("Great! Let's get you started on your journey to the top of Wool Street!");
            System.out.println("Onto our first quarter...");

        } else if(response.equals("no")) {
            System.out.println("Who put you in charge? Wool Street doesn't wait for nobahhdy!");
            gameCommence();
        } else {
            System.out.println("What the flock are you even saying?? I have no idea what to do with that information...");
            gameCommence();
        }
    }

    /**
     * Calls methods that actually run the functionality of the game.
     */
    public void gameCommence() {
        System.out.println("-------------------------------------------" + "\n");
        gameOver = true;
        
    }



    public boolean isGameOver() {
        gameOver = currentQuarter > 4 || account.getBalance() <= 0; // Check if the game is over
        return gameOver;
    }

    public static void main(String[] args) {
        GameFunctions newGame = new GameFunctions();
    
        StatsListener statsListener = new StatsListener(newGame);
        
        statsListener.setDaemon(true); // Set the stats listener as a daemon thread
        statsListener.start(); // Start the stats listener thread
        
        newGame.gameIntro();
        newGame.inbetweenFirstScenario();
        newGame.startGame();

        newGame.increaseQuarter();

        while(newGame.isGameOver() != true) {
            switch (newGame.getCurrentQuarter()) {
                case 1 -> {
                    ScenarioOne scenarioOne = new ScenarioOne();
                    scenarioOne.startScenarioOne();
                    newGame.increaseQuarter();
                }
                case 2 -> {
                    ScenarioTwo scenarioTwo = new ScenarioTwo(newGame);
                    scenarioTwo.startScenarioTwo();
                    newGame.increaseQuarter();
                }
                case 3 -> {
                    ScenarioThree scenarioThree = new ScenarioThree(newGame);
                    scenarioThree.startScenarioThree();
                    newGame.increaseQuarter();
                }
                case 4 -> {
                    ScenarioFour scenarioFour = new ScenarioFour(newGame);
                    scenarioFour.startScenarioFour();
                    newGame.increaseQuarter();
                }
            }
        }
        if (newGame.isGameOver()) {
            System.out.println("Game Over! You have reached the end of your journey on Wool Street.");
        }
        if(newGame.getAccount().getBalance() <= 0) {
            System.out.println("You went bankrupt! Guess you were a sheep in wolf's clothing instead!");
        } else {
            System.out.println("Congratulations " + newGame.getAccount().getName() + "! You made it to the top of Wool Street with " + newGame.getAccount().getBalance());
        }
    

    }
}


