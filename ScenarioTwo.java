
import java.util.Random;
import java.util.Scanner;

public class ScenarioTwo {
    
    // Assuming necessary imports and class variables are defined here
    private Scanner in = new Scanner(System.in);
    Random rand = new Random();
    int randomNumber = rand.nextInt(3) + 1;

    public void startScenarioTwo() {
        switch (randomNumber) {
            case 1 -> {
                System.out.println("Scenario One: You have a choice to make!");
                optionOneStart();
            }
            case 2 -> {
                System.out.println("Scenario One: A different path awaits you!");
                optionTwo();
                // Logic for another option can be added here
            }
            case 3 -> {
                System.out.println("Scenario One: A surprise event occurs!");
                optionThree();
                // Logic for a surprise event can be added here
            }
            default -> System.out.println("Unexpected scenario number.");
        }

        // Add dialogue or logic for the chosen scenario here, or starting the next
        // room or quarter in the game.

    }

    public void optionOneStart() {
        System.out.println("A major competitor has just announced a new product that could threaten your business.");
        System.out.println("Type 1 to launch a counter-campaign or 2 to ignore it and focus on your current strategy: ");
        competitorThreat();
    }
    
    public void competitorThreat() {
        String choice = in.nextLine();
        
        if(choice.equals("1")) {
            for(Employees e : employees) {
                e.increaseMorale(3);
            }
            System.out.println("Your employees are motivated by the challenge!");
        }
        else if(choice.equals("2")) {
            for(Employees e : employees) {
                e.decreaseMorale(2);
            }
            System.out.println("Your employees feel demotivated by the lack of action.");
        }
        else {
            System.out.println("Invalid choice. Please choose again: ");
            competitorThreat();
        }
    }

    public void optionTwo() {
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
                    optionTwo();
                }
            }
            System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
            playersChoice = in.next();
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    } 

    public void optionThree() {
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
                    playersChoice = in.next();
                }
            }
            System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
            playersChoice = in.next();
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    } 

    // Update these
}
