import java.util.Scanner;

public class GameFunctions {
    private String playerName;

    public GameFunctions() {
        this.playerName = "Player";
    }

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

    public void setPlayerName() {
        Scanner playerScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        this.playerName = playerScanner.nextLine();

        System.out.println("Great. Let's get you to the top " + playerName + "!");
    }

    public void startGame() {
        System.out.println("Ready to begin? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            gameCommence();
        } else if (response.equals("no")) {
            System.out.println("Who put you in charge? Wool Street doesn't wait for nobahhdy!");
            gameCommence();
        } else {
            System.out.println("What the flock are you even saying?? I have no idea what to do with that information...");
            startGame();
        }
    }

    public void gameCommence() {
        System.out.println("-------------------------------------------" + "\n");
    }

    public static void main(String[] args) {
        GameFunctions newGame = new GameFunctions();
    
        newGame.gameIntro();
    }
    
}


