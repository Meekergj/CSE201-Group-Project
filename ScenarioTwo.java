
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScenarioTwo {
    
    private Scanner in = new Scanner(System.in);
    Random rand = new Random();
    int randomNumber = rand.nextInt(4) + 1;

    private GameFunctions gameFunction;
    private Account account;
    private List<Stock> stockPortfolio;
    private Employees employees;

    public ScenarioTwo(GameFunctions gameFunction) {
        this.gameFunction = gameFunction;
        this.employees = gameFunction.getEmployees();
        this.account = gameFunction.getAccount();
        this.stockPortfolio = gameFunction.getPortfolio();
    }
    // Assuming necessary imports and class variables are defined here


    public void startScenarioTwo() {
        switch (randomNumber) {
            case 1 -> {
                System.out.println("Quarter Two: You have a choice to make!");
                optionOneStart();
            }
            case 2 -> {
                System.out.println("Quarter Two: A different path awaits you!");
                optionTwo();
                // Logic for another option can be added here
            }
            case 3 -> {
                System.out.println("Quarter Two: A surprise event occurs!");
                optionThree();
                // Logic for a surprise event can be added here
            }
            case 4 -> {
                System.out.println("Quarter Two: A new opportunity arises!");
                optionFour();
                // Logic for a new opportunity can be added here
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
        
        switch (choice) {
            case "1" -> {
                employees.changeMoral(5);
                System.out.println("Your employees are motivated by the challenge!");
            }
            case "2" -> {
                employees.changeMoral(5);
                System.out.println("Your employees feel demotivated by the lack of action.");
            }
            default -> {
                System.out.println("Invalid choice. Please choose again: ");
                competitorThreat();
            }
        }
    }

    public void optionTwo() {
        System.out.println("Surprise!\n You found a wallet on the ground, it had $500 in it!" + 
                            "Type 1 to pick it up and keep the money\n or 2 to bring it to the police.\n");
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
                    System.out.println("Congratulations! You chose to keep the money. Your account balance has increased by $500.");
                    gameFunction.getAccount().updateBalance(500);
                    // Logic for safe investment scenario can be added here
                }
                case 2 -> {
                    System.out.println("You chose to bring the wallet to the police. Your honesty is commendable, but you missed out on $500.");
                    gameFunction.getEmployees().changeMoral(5);
                    // Logic for risky investment scenario can be added here
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 or 2");
                    optionTwo();
                }
            }
        }
    } 

    public void optionThree() {
        System.out.println("Your employees are asking you, their boss to go out with them " +
                            "for a team-building event and drinks." +
                            "Type 1 to join them or 2 to decline the invitation.\n");
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
                    System.out.println("You chose to join your employees for a team-building event. " +
                            "Your employees feel appreciated and their morale increases!");
                    gameFunction.getEmployees().changeMoral(10);
                    gameFunction.getAccount().updateBalance(-100); // Assuming a cost for the event
                    // Logic for safe investment scenario can be added here
                }
                case 2 -> {
                    System.out.println("You chose to decline the invitation. " +
                            "Your employees feel disappointed and their morale decreases.");
                    gameFunction.getEmployees().changeMoral(-10);

                    // Logic for risky investment scenario can be added here
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
                    optionThree();
                }
            }
        }
    } 

    public void optionFour() {
        System.out.println("A homeless man is asking you for money!" +
                            "Type 1 to give him $100 or 2 to ignore him.\n");
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
                    System.out.println("You chose to give him $100. Your account balance has decreased by $100.");
                    gameFunction.getAccount().updateBalance(-100);
                    // Logic for safe investment scenario can be added here
                }
                case 2 -> {
                    System.out.println("You chose to ignore him. Your employee saw and thinks less of you.");
                    gameFunction.getEmployees().changeMoral(-5);
                    // Logic for risky investment scenario can be added here
                }
                default -> {
                    System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
                    optionFour();
                }
            }
        }
    }

    // Update these
}
