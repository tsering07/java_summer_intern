import java.util.ArrayList;

public class GameEngine {
    private ArrayList<Player> players;
    private Dice dice;

    public GameEngine(ArrayList<Player> players) {
        this.players = players;
        this.dice = new Dice();
    }

    public void playRound() {
        int highestRoll = 0;
        Player roundWinner = null;
        boolean isTie = false;

        System.out.println("\n🎲 Rolling dice...");

        for (Player p : players) {
            int roll = dice.roll();
            System.out.println(p.showName() + " rolled: " + roll);

            if (roll > highestRoll) {
                highestRoll = roll;
                roundWinner = p;
                isTie = false;
            } else if (roll == highestRoll) {
                isTie = true;
            }
        }

        if (!isTie && roundWinner != null) {
            roundWinner.incrementWins();
            System.out.println("🏆 " + roundWinner.showName() + " wins this round!\n");
        } else {
            System.out.println("🤝 It's a tie! No one wins this round.\n");
        }
    }

    public void showResults() {
        System.out.println("📊 Scoreboard:");
        for (Player p : players) {
            System.out.println(p.showName() + " has won " + p.showWins() + " rounds");
        }
    }
}
