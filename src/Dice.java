import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int[] dice;
    private int rerolls;

    public Dice() {
        dice = new int[5];
        rerolls = 0;
    }

    public void roll() {
        for (int i = 0; i < 5; i++) {
            dice[i] = ThreadLocalRandom.current().nextInt(1,7);
        }
    }

    public boolean reroll(int[] targets) {
        if (rerolls >= 2) {
            return false;
        }
        if (targets.length > 5) {
            return false;
        }
        rerolls++;
        for (int i : targets) {
            dice[i] = ThreadLocalRandom.current().nextInt(1,7);
        }
        return true;
    }

    public int[] getRoll() {
        return dice;
    }
}
