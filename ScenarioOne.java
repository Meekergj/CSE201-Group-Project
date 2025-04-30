import java.util.Scanner;

public class ScenarioOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! Would you prefer a safe investment or a risky investment?" + "Type 1 for safe, or 2 for risky.");
        String playersChoice = in.next();
        int playersChoiceInt = 0;
        try {
            playersChoiceInt = Integer.parseInt(playersChoice);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
        while (playersChoiceInt != 1 && playersChoiceInt != 2) {
            System.out.println("Input not recognized. Please type 1 for safe " + "investment, or 2 for a risky investment.");
            playersChoice = in.next();
            try {
                playersChoiceInt = Integer.parseInt(playersChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}

