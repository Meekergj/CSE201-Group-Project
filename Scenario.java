import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Class: Scenario
 *
 * @author Gavin Meeker
 * @version 0.2 Course: CSE 201 Spring 2025 Written: April 9, 2025
 *     <p>Purpose: Manages the 4 scenarios/rooms of the text adventure by being the parent class to
 *                 events that happen in each of the scenarios.
 */

public class Scenario {
    // Define attributes
    private String description;
    private String option1;
    private String option2;
    private Consumer<GameState> action1;
    private Consumer<GameState> action2;



    // Constructor
    public Scenario(String description, String option1, String option2,
                    Consumer<GameState> action1, Consumer<GameState> action2) {
        this.description = description;
        this.option1 = option1;
        this.option2 = option2;
        this.action1 = action1;
        this.action2 = action2;
    }
    // Methods
    /*
     * Each child class will override this method to have unique text discriptions
     */
    public void displayScenario(GameState state) {
        System.out.println(description);
        System.out.println("1. " + option1);
        System.out.println("2. " + option2);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            action1.accept(state);
        } else if (choice == 2) {
            action2.accept(state);
        } else {
            System.out.println("Invalid choice. Please try again.");
            displayScenario(state); // Re-display scenario if invalid choice
        }

    }



}
