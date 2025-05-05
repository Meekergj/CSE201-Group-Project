import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class: GameFunctions
 * @author: Braden Gaerke
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 5/04/2025
 * 
 * Purpose: Runs functions that set up the game and give opening information about how it works. Does not include mechanics.
 *  Also helps manage the player's account, employees, and stock portfolio, as well as the quarters and months. 
 */
public class GameFunctions {

    private static Account account; // Default account with initial balance
    private static Employees employees = new Employees(); // Default employees
    private static List<Stock> portfolio = new ArrayList<>(); // Default empty portfolio
    private static List<Stock> market = new ArrayList<>(); // Default empty market
    private int currentQuarter; // Current quarter of the game
    private boolean gameOver = false; // Indicates if the game is over
    private boolean isCollapse = false; // Indicates if a market collapse has occurred

    // Constructor with parameters to initialize the game state
    // @param account The player's account
    //@param employees The player's employees
    //@param portfolio The player's stock portfolio
    public GameFunctions(Account account, Employees employees, List<Stock> portfolio) {
        this.account = account;
        this.employees = employees;
        this.portfolio = portfolio;
        this.currentQuarter = 1;
    }
    //Default constructor to initialize the game state with default values
    public GameFunctions() {
        this.account = new Account(10000, "Jordan");
        this.currentQuarter = 0; // Initialize currentQuarter to 0
    }

    //An option for players to see at any month of the game
    public void displayStats() {
        System.out.println("\n========= GAME STATS =========");
        System.out.println("Player Name: " + account.getName());
        System.out.println("Account Balance: $" + account.getBalance());
        System.out.println("Current Quarter: " + currentQuarter);
        System.out.println("Employee Morale: " + employees.getMorale());
        System.out.println("Employee Productivity: " + employees.getProductivity());
        if (portfolio.isEmpty()) {
            System.out.println("Stock Portfolio: No stocks owned");
        } else {
            System.out.println("Stock Portfolio:");
            for (Stock s : portfolio) {
                s.displayStock();
            }
        }
    
        if (portfolio.isEmpty()) {
            System.out.println("  (No stocks owned)");
        } else {
            for (Stock stock : portfolio) {
                System.out.println("  - " + stock.getCompanyName() + " | Shares Owned: " + stock.getSharesOwned() + " | Value: $" + stock.getValue());
            }
        }
        System.out.println("================================\n");
    }
    
    // Increases the quarter
    public void increaseQuarter() {
        this.currentQuarter++;
    }   
    // Setters and Getters
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public void setPortfolio(List<Stock> portfolio) {
        this.portfolio = portfolio;
        }

        public Account getAccount() { return account; }
        public Employees getEmployees() { return employees; }
        public List<Stock> getPortfolio() { return portfolio; }

    public int getCurrentQuarter() {
        return currentQuarter;
    }   

    /**
     * Gives the player an introduction to the game setting.
     */
    public void gameIntro(Scanner scanner) {
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
        System.out.println("I'd rather be bahhhtty and a millionaire than working a 9-5 at Macdonald's or Shears.");
        System.out.println("-------------------------------------------");

        setPlayerName(scanner);
        
        System.out.println("Great. Let's get you to the top, " + account.getName() + "!");
    }

    /**
     * Sets the player's name when prompted.
     * @param scanner The Scanner object to read user input
     */
    public void setPlayerName(Scanner scanner) {
        System.out.print("Enter your name: \n");
        String playerName = scanner.nextLine().trim();

        Account newAccount = new Account(10000, playerName);
        this.account = newAccount;
    }
    // Some dialogue before starting
    public void inbetweenFirstScenario() {
        System.out.println("Before we get started, let's go over some basics.");
        System.out.println("You start with a balance of $" + account.getBalance() + " and your goal is to increase your wealth by making smart investments.");
        System.out.println("Each quarter, you'll face different scenarios that will test your investment skills.");
        System.out.println("Make choices wisely, as they will affect your balance and the outcome of the game.");
        System.out.println("Remember, you can go bankrupt if your balance drops to .00 or below.");
        System.out.println("Good luck, " + account.getName() + "! Let's get started! (Hit enter)");
    }

    /**
     * Asks the player if they are ready to begin and calls the gameCommence method if yes.
     * If no, the game starts anyways because that's just Wool Street for you.
     * @param scanner The Scanner object to read user input
     */
    public void startGame(Scanner scanner) {
        while (true) {
            // Flush any leftover newlines in the buffer before taking input
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Discards the leftover newline if there was any
            }
    
            System.out.println("Ready to begin? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase(); // Capture input properly
            
            // Debugging to see what the input looks like
            System.out.println("User input: " + response);
    
            if (response.equals("yes")) {
                System.out.println("Great! Let's get you started...");
                break;
            } else if (response.equals("no")) {
                System.out.println("Who put you in charge? Wool Street doesn't wait for nobahhdy!");
                break;
            } else {
                System.out.println("What the flock are you even saying??");
            }
        }
    }

    /**
     * Calls methods that actually run the functionality of the game.
     * not used
     */
    public void gameCommence() {
        System.out.println("-------------------------------------------" + "\n");
        gameOver = true;
        
    }
    // Deactivates a stock in the portfolio by removing it at the specified index
    public void deactivateStock(int index) {
        portfolio.remove(index);
    }
    // Starts a market collapse by setting the isCollapse flag to true
    public void startCollapse() {
        System.out.println("Market collapse imminent!");
        isCollapse = true;
    }
    // Buys shares of a stock from the market and adds it to the portfolio if not already owned
    // @param portfolio The player's stock portfolio
    //@param market The list of available stocks in the market
    //@param account The player's account
    //@param scanner The Scanner object to read user input
    public void buyShares(List<Stock> portfolio, List<Stock> market, Account account, Scanner scanner) {
        System.out.println("Available stocks to buy:");
        for (int i = 0; i < market.size(); i++) {
            System.out.print((i + 1) + ". ");
            market.get(i).displayStock();
        }
    
        System.out.print("Enter the number of the stock to buy: ");
        try {
            int stockIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (stockIndex < 0 || stockIndex >= market.size()) {
                System.out.println("Invalid stock number.");
                return;
            }
    
            Stock chosenStock = market.get(stockIndex);
            System.out.print("Enter number of shares to buy: ");
            double shares = Double.parseDouble(scanner.nextLine());
            double cost = chosenStock.getValue() * shares;
    
            if (account.getBalance() >= cost) {
                account.updateBalance(cost);
                chosenStock.buyShares(shares);
                if (!portfolio.contains(chosenStock)) {
                    portfolio.add(chosenStock);
                }
                System.out.println("Purchased " + shares + " shares of " + chosenStock.getCompanyName());
            } else {
                System.out.println("Not enough balance to complete the purchase.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Purchase cancelled.");
        }
    }
    
    /*
    public void runMonthlyActivities(List<Stock> market, Employees employees, Account account, List<Stock> portfolio, Scanner scanner) {
        boolean isCollapse = false;
        int currentQuarter = getCurrentQuarter();
    
        // === SCENARIO: Run once per quarter ===
        System.out.println("[Quarter " + currentQuarter + " Scenario]");
        switch (currentQuarter) {
            case 1 -> {
                ScenarioOne scenarioOne = new ScenarioOne(this, scanner);
                scenarioOne.startScenarioOne();
            }
            case 2 -> {
                ScenarioTwo scenarioTwo = new ScenarioTwo(this, scanner);
                scenarioTwo.startScenarioTwo();
            }
            case 3 -> {
                ScenarioThree scenarioThree = new ScenarioThree(this, scanner);
                scenarioThree.startScenarioThree();
            }
            case 4 -> {
                ScenarioFour scenarioFour = new ScenarioFour(this, scanner);
                scenarioFour.startScenarioFour();
            }
        }
    
        // === Monthly loop ===
        for (int month = 1; month < 4; month++) {
            System.out.println("\nMonth " + month + " of Quarter " + currentQuarter);
            System.out.println("You can buy shares, hire employees, or manage your portfolio.(Enter)");

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Flush the buffer BEFORE asking the first month input
            }
            System.out.print("Enter your choice, invalid input will skip: (buy/hire/skip/stats): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            
            
            // === TICK: Update all stock values ===
            System.out.println("\n[ Stock market update... ]");
            for (Stock stock : market) {
                double oldValue = stock.getValue();
                double newValue = stock.tickFowardValue();
    
                // If there's a collapse in this quarter, simulate the drop
                if (isCollapse) {
                    newValue *= 0.6; // Drop by 40%
                    System.out.println("Market crash! " + stock.getCompanyName() + " drops to $" + String.format("%.2f", newValue));
                }
    
                stock.setValue(newValue);
                stock.setChangeInValue(stock.calculateChangeInValue(oldValue, newValue));
            }
            // === Display updated market ===
            displayMarket(market);
    
            // Process input based on the user's choice
            switch (choice) {
                case "buy":
                    buyShares(portfolio, market, account, scanner);
                    break;
                case "hire":
                    System.out.print("How many employees do you want to hire?($50/each)");
                    try {
                        int count = Integer.parseInt(scanner.nextLine().trim());
                        double cost = employees.hireEmployees(count);
                        if (account.getBalance() >= cost) {
                            account.updateBalance(cost);
                            System.out.println("Hired " + count + " employees for $" + cost);
                        } else {
                            System.out.println("Not enough funds to hire that many employees.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Skipping.");
                    }
                    break;
                case "stats":
                    displayStats();
                    break;
                case "skip":
                    System.out.println("Skipping this month...");
                    break;
                default:
                    System.out.println("Invalid choice. Skipping this month...");
                    break;
            }
        }
    }
    */
    // Runs the scenario for the current quarter
    // @param currentQuarter The current quarter of the game
    // @param scanner The Scanner object to read user input
    public void runQuarterScenario(int currentQuarter, Scanner scanner) {
        System.out.println("[Quarter " + currentQuarter + " Scenario]");
        switch (currentQuarter) {
            case 1 -> new ScenarioOne(this, scanner).startScenarioOne();
            case 2 -> new ScenarioTwo(this, scanner).startScenarioTwo();
            case 3 -> new ScenarioThree(this, scanner).startScenarioThree();
            case 4 -> new ScenarioFour(this, scanner).startScenarioFour();
            default -> System.out.println("No scenario for this quarter.");
        }
    }
    // Processes monthly actions based on user input
    //@param market The list of available stocks in the market
    //@param scanner The Scanner object to read user input
    public void processMonthlyActions(List<Stock> market, Scanner scanner) {
        System.out.println("You can buy shares, hire employees, or manage your portfolio.");
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Flush the buffer BEFORE asking the first month input
        }
        System.out.print("Enter your choice, invalid input will skip: (buy/hire/skip/stats): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "buy":
                buyShares(portfolio, market, account, scanner);
                break;
            case "hire":
                System.out.print("How many employees do you want to hire? ($50/each): ");
                try {
                    int count = Integer.parseInt(scanner.nextLine().trim());
                    double cost = employees.hireEmployees(count);
                    if (account.getBalance() >= cost) {
                        account.updateBalance(cost);
                        System.out.println("Hired " + count + " employees for $" + cost);
                    } else {
                        System.out.println("Not enough funds.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Skipping hiring.");
                }
                break;
            case "stats":
                displayStats();
                break;
            case "skip":
                System.out.println("Skipping this month...");
                break;
            default:
                System.out.println("Invalid input. Skipping.");
        }
    }
    // Updates the stock market by ticking forward the value of each stock
    // @param market The list of available stocks in the market

    public void tickMarket(List<Stock> market) {
        System.out.println("\n[ Stock market update... ]");
    
        for (Stock stock : market) {
            double oldValue = stock.getValue();
            double newValue = stock.tickFowardValue();
    
            if (isCollapse) {
                newValue *= 0.6;
                System.out.println("Market crash! " + stock.getCompanyName() + " drops to $" + String.format("%.2f", newValue));
            }
    
            stock.setValue(newValue);
            stock.setChangeInValue(stock.calculateChangeInValue(oldValue, newValue));
        }
    
        displayMarket(market);
    }

    // Method that calls all above helper method to keep game running throughout the "year"
    /*
     * @param market The list of available stocks in the market
     * @param employees The player's employees
     * @param account The player's account
     * @param portfolio The player's stock portfolio
     * @param scanner The Scanner object to read user input
     */
    public void runMonthlyActivities(List<Stock> market, Employees employees, Account account, List<Stock> portfolio, Scanner scanner) {
        runQuarterScenario(currentQuarter, scanner);
    
        for (int month = 1; month <= 3; month++) {
            System.out.println("\nMonth " + month + " of Quarter " + currentQuarter);
            processMonthlyActions(market, scanner);
            tickMarket(market);
        }
    }
    
    
    // Displays the current state of the stock market
    //@param market The list of available stocks in the market
    public void displayMarket(List<Stock> market) {
        System.out.println("\n=== Market Overview ===");
        for (Stock stock : market) {
            stock.displayStock();
        }
    }
    
    
    // Checks if the game is over based on the current quarter and account balance
    public boolean isGameOver() {
        gameOver = currentQuarter > 4 || account.getBalance() <= 0; // Check if the game is over
        return gameOver;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // ← SINGLE SHARED SCANNER
    
        market.add(new Stock("Sahara", 9));
        market.add(new Stock("Gogle", 2));
        market.add(new Stock("Jim Bortons", 6));
        market.add(new Stock("Blue Skies", 5));
        market.add(new Stock("Null Co", 5));
        market.add(new Stock("Bahthesda", 8));
        market.add(new Stock("Shallow Mind", 4));
        market.add(new Stock("Pear", 4));
        market.add(new Stock("Unusual Oil", 7));
    
        GameFunctions newGame = new GameFunctions();
        /** 
        StatsListener statsListener = new StatsListener(newGame, scanner);
        statsListener.setDaemon(true);
        statsListener.start();
        */
        newGame.gameIntro(scanner);
        newGame.inbetweenFirstScenario();
        newGame.startGame(scanner);
    
        newGame.increaseQuarter();

        while (!newGame.isGameOver()) {
            newGame.runMonthlyActivities(market, employees, newGame.account, portfolio, scanner);
            newGame.account.updateBalance(employees.setTotalProduction());
            
            newGame.increaseQuarter();
        }
    
        if (newGame.account.getBalance() <= 0) {
            System.out.println("You went bankrupt!");
        } else {
            System.out.println("Congrats! Final Balance: $" + newGame.account.getBalance());
        }
    
        scanner.close(); // Always close it at the end
    }
    }


