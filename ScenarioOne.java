import java.util.List;
import java.util.Scanner;

public class ScenarioOne {

    // Takes care of starting the scenario, as there are multiple options, 3 
    // rooms there could be for each scenario.

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;

    public ScenarioOne(GameFunctions gameFunction) {
        this.gameFunction = gameFunction;
        this.employees = gameFunction.getEmployees();
        this.account = gameFunction.getAccount();
        this.stockPortfolio = gameFunction.getPortfolio();
    }
    
    public void startScenarioOne() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! Would you prefer a safe investment or a risky investment?" + "Type 1 for safe, or 2 for risky.");
        String playersChoice = in.next();
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
                    // Logic for safe investment scenario can be added here
                }
                case 2 -> {
                    System.out.println("You chose a risky investment. Brace yourself!");
                    // Logic for risky investment scenario can be added here
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
                    startScenarioOne();
                }
            }
        }
        in.close();
    }
    

}


