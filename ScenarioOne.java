import java.util.List;
import java.util.Scanner;

public class ScenarioOne {

    // Takes care of starting the scenario, as there are multiple options, 3 
    // rooms there could be for each scenario.

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;
    private Scanner scanner;

    public ScenarioOne(GameFunctions gameFunction, Scanner scanner) {
        this.scanner = scanner;
        this.gameFunction = gameFunction;
        this.employees = gameFunction.getEmployees();
        this.account = gameFunction.getAccount();
        this.stockPortfolio = gameFunction.getPortfolio();
    }
    
    public void startScenarioOne() {
        System.out.println("Welcome! \n It is the first quarter of the year, and you have a choice to make! \n" + 
                           "Would you prefer a safe investment or a risky investment? \n" + 
                           "Type 1 for safe, or 2 for risky.");
        String playersChoice = scanner.next();
        int playersChoiceInt = -1;

        while (playersChoiceInt != 1 && playersChoiceInt != 2) {
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                // Player did not enter a number.
                System.out.println("Try Again. Please enter a number.");
            }
            switch (playersChoiceInt) {
                case 1 -> {
                    System.out.println("You chose a safe investment. Good luck!");
            
                    // Safe investment has a modest gain
                    double gain = 500 + Math.random() * 500; // Gain between $500–$1000
                    account.updateBalance(gain);
                    System.out.printf("Your investment paid off with a return of $%.2f!\n", gain);
            
                    // Safe choice slightly boosts morale
                    employees.changeMorale(1.0);
                    System.out.println("Your employees are more confident in your leadership. Morale has increased.");
                }
                case 2 -> {
                    System.out.println("You chose a risky investment. Brace yourself!");
            
                    // Risky investment can gain big or lose
                    double roll = Math.random();
                    if (roll < 0.5) {
                        // Loss
                        double loss = 1000 + Math.random() * 2000; // Loss between $1000–$3000
                        account.updateBalance(-loss);
                        System.out.printf("Your investment tanked. You lost $%.2f!\n", loss);
            
                        // Risky loss decreases morale and productivity
                        employees.changeMorale(-1.5);
                        employees.changeProductivity(-1.5);
                        System.out.println("Your employees are worried. Morale and productivity have decreased.");
                    } else {
                        // Win
                        double profit = 2000 + Math.random() * 3000; // Gain between $2000–$5000
                        account.updateBalance(profit);
                        System.out.printf("High risk, high reward! You earned $%.2f!\n", profit);
            
                        // Risky win increases morale and productivity
                        employees.changeMorale(2.0);
                        employees.changeProductivity(2.0);
                        System.out.println("Your bold decision paid off. Morale and productivity have increased.");
                    }
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe investment, or 2 for a risky investment.");
                    startScenarioOne(); // Recurse if input is bad
                }
            }
        }
    }
    

}


