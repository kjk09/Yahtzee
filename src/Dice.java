import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int[] dice;

    public Dice() {
        dice = new int[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = ThreadLocalRandom.current().nextInt(1,7);
        }
    }

    public boolean reroll(int[] targets) {
        if (targets.length > 5) {
            return false;
        }
        for (int i : targets) {
            dice[i] = ThreadLocalRandom.current().nextInt(1,7);
        }
        return true;
    }

    public int[] getRoll() {
        return dice;
    }

    @Override
    public String toString() {
        return dice[0] + ", " + dice[1] + ", " + dice[2] + ", " + dice[3] + ", " + dice[4];
    }
}
