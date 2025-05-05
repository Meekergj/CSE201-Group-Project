
import java.util.Scanner;

class StatsListener extends Thread {
    private final GameFunctions game;
// Multi-threading is used here to allow the game to run concurrently with user input for stats display.
    public StatsListener(GameFunctions game) {
        this.game = game;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!game.isGameOver()) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s")) {
                game.displayStats();
            }
        }
    }
}
