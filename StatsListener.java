
import java.util.Scanner;

public class StatsListener extends Thread {
    private GameFunctions gameFunctions;
    private Scanner scanner;
    
    public StatsListener(GameFunctions gameFunctions, Scanner scanner) {
        this.gameFunctions = gameFunctions;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = scanner.nextLine();
                
                // Press 's' to display stats
                if (input.equalsIgnoreCase("`")) {
                    displayStats();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void displayStats() {
        System.out.println("\n=== Player Stats ===");
        System.out.println("Player Name: " + gameFunctions.getAccount().getName());
        System.out.println("Current Balance: $" + gameFunctions.getAccount().getBalance());
        System.out.println("Employees: " + gameFunctions.getEmployees().getEmployeeCount());
        System.out.println("Stock Portfolio: ");
        for (Stock stock : gameFunctions.getPortfolio()) {
            stock.displayStock();
        }
    }
}
