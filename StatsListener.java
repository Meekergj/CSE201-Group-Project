
import java.util.Scanner;
/**
 * We didn't end up using this class in the final implementation, but it was intended to
 * provide a way for players to view their stats at any time during the game.
 * Class: StatsListener
 * Author: Braden Gaerke
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 5/04/2025
 *
 */

public class StatsListener extends Thread {
    private GameFunctions gameFunctions;
    private Scanner scanner;
    
    public StatsListener(GameFunctions gameFunctions, Scanner scanner) {
        this.gameFunctions = gameFunctions;
        this.scanner = scanner;
    }

    // Runs the multithread listener
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
    // What would happen after clicking S
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
