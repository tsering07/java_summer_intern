import java.util.Random;

public class Dice {
    private final Random rand = new Random();

    public int roll() {
        return rand.nextInt(6) + 1; // Generates number between 1 and 6
    }
}
