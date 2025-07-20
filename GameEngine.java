import java.util.ArrayList;

public class GameEngine {
    private final ArrayList<Player> players;
    private final Dice dice;

    public GameEngine(ArrayList<Player> players) {
        this.players = players;
        this.dice = new Dice();
    }

    public void playRound() {
        int highestRoll = 0;
        Player winner = null;
        boolean isTie = false;

        System.out.println("\n🎲 Rolling the dice...");

        for (Player player : players) {
            int roll = dice.roll();
            System.out.println(player.getName() + " rolled: " + roll);

            if (roll > highestRoll) {
                highestRoll = roll;
                winner = player;
                isTie = false;
            } else if (roll == highestRoll) {
                isTie = true;
            }
        }

        if (!isTie && winner != null) {
            winner.addWin();
            System.out.println("🏆 " + winner.getName() + " wins this round!\n");
        } else {
            System.out.println("🤝 It's a tie! No winner this round.\n");
        }
    }

    public void displayScoreboard() {
        System.out.println("\n📊 Current Scoreboard:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getWins() + " wins");
        }
    }
}
