import java.util.ArrayList;
import java.util.Scanner;

public class Executer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎮 Welcome to the Dice Game!");
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        GameEngine game = new GameEngine(players);

        while (true) {
            System.out.print("\nDo you want to play a round? (1 = Yes / 0 = No): ");
            int choice = sc.nextInt();
            if (choice == 1) {
                game.playRound();
                game.showResults();
            } else {
                System.out.println("👋 Thanks for playing!");
                break;
            }
        }

        sc.close();
    }
}
