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
    private String playerName;
    private static int currentQuarter = 1;

    public GameFunctions() {
        this.playerName = "Player";
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

        setPlayerName();
        System.out.println("-------------------------------------------" + "\n");
        
        startGame();
    }

    /**
     * Sets the player's name when prompted.
     */
    public void setPlayerName() {
        Scanner playerScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        this.playerName = playerScanner.nextLine();

        System.out.println("Great. Let's get you to the top " + playerName + "!");
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
            gameCommence();
        } else if(response.equals("no")) {
            System.out.println("Who put you in charge? Wool Street doesn't wait for nobahhdy!");
            gameCommence();
        } else {
            System.out.println("What the flock are you even saying?? I have no idea what to do with that information...");
            startGame();
        }
    }

    /**
     * Calls methods that actually run the functionality of the game.
     */
    public void gameCommence() {
        System.out.println("-------------------------------------------" + "\n");
    }

    public int getCurrentQuarter() {
        return currentQuarter;
    }

    public void incrementQuarter() {
        currentQuarter++;
    }

    public static boolean isGameOver() {
        return currentQuarter > 4 || Account.getBalance() <= 0;
    }

    public static void main(String[] args) {
        GameFunctions newGame = new GameFunctions();
    
        newGame.gameIntro();

        while(isGameOver() != true) {
            if(currentQuarter == 1) {
                ScenarioOne scenarioOne = new ScenarioOne();
                scenarioOne.scenarioOneStart();
            } else if(currentQuarter == 2) {
                ScenarioTwo scenarioTwo = new ScenarioTwo();
                scenarioTwo.scenarioTwoStart();
            } else if(currentQuarter == 3) {
                ScenarioThree scenarioThree = new ScenarioThree();
                scenarioThree.scenarioThreeStart(); 
            } else if(currentQuarter == 4) {
                ScenarioFour scenarioFour = new ScenarioFour();
                scenarioFour.scenarioFourStart();
            }
        }

        if(Account.getBalance() <= 0) {
            System.out.println("You went bankrupt! Guess you were a sheep in wolf's clothing instead!");
        } else {
            System.out.println("Congratulations " + newGame.playerName + "! You made it to the top of Wool Street with " + Account.getBalance());
        }
    }
}


