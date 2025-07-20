import java.util.ArrayList;
import java.util.Scanner;

public class Executer {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🎮 Welcome to the Dice Game!");

        int numberOfPlayers = getIntInput("Enter number of players: ", 1, 100);
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            players.add(new Player(sc.nextLine().trim()));
        }

        GameEngine game = new GameEngine(players);

        while (true) {
            int choice = getIntInput("\nDo you want to play a round? (1 = Yes / 0 = No): ", 0, 1);
            if (choice == 1) {
                game.playRound();
                game.displayScoreboard();
            } else {
                System.out.println("👋 Thanks for playing!");
                break;
            }
        }

        sc.close();
    }

    private static int getIntInput(String message, int min, int max) {
        int input = -1;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine(); 
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                sc.nextLine(); 
            }
            System.out.println("❌ Invalid input. Please enter a number between " + min + " and " + max + ".");
        }
    }
}
