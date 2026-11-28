import java.util.Arrays;

public class Player {
    private final String name;
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeOAK;
    private int fourOAK;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yahtzee;
    private int chance;

    public Player(String name) {
        this.name = name;
        ones = -1;
        twos = -1;
        threes = -1;
        fours = -1;
        fives = -1;
        sixes = -1;
        threeOAK = -1;
        fourOAK = -1;
        fullHouse = -1;
        smallStraight = -1;
        largeStraight = -1;
        yahtzee = -1;
        chance = -1;

    }

    public String getName() {
        return this.name;
    }

    public int getOnes() {
        return ones;
    }

    public int getTwos() {
        return twos;
    }

    public int getThrees() {
        return threes;
    }

    public int getFours() {
        return fours;
    }

    public int getFives() {
        return fives;
    }

    public int getSixes() {
        return sixes;
    }

    public int getThreeOAK() {
        return threeOAK;
    }

    public int getFourOAK() {
        return fourOAK;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public int getLargeStraight() {
        return largeStraight;
    }

    public int getYahtzee() {
        return yahtzee;
    }

    public int getChance() {
        return chance;
    }

    public int getScore() {
        int sum = 0;
        for (int i : new int[]{ones, twos, threes, fours, fives, sixes,
                threeOAK, fourOAK, fullHouse, smallStraight, largeStraight,
                yahtzee, chance}) {
            if (i == -1) {
                sum++;
            }
        }
        sum += ones + twos + threes + fours + fives + sixes
                + threeOAK + fourOAK + fullHouse + smallStraight + largeStraight
                + yahtzee + chance;
        return sum;
    }



    public boolean scoreOnes(int[] dice) {
        if (ones != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 1) {
                score++;
            }
        }
        ones = score;
        return true;
    }

    public boolean scoreTwos(int[] dice) {
        if (twos != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 2) {
                score += 2;
            }
        }
        twos = score;
        return true;
    }

    public boolean scoreThrees(int[] dice) {
        if (threes != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 3) {
                score += 3;
            }
        }
        threes = score;
        return true;
    }

    public boolean scoreFours(int[] dice) {
        if (fours != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 4) {
                score += 4;
            }
        }
        fours = score;
        return true;
    }

    public boolean scoreFives(int[] dice) {
        if (fives != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 5) {
                score += 5;
            }
        }
        fives = score;
        return true;
    }

    public boolean scoreSixes(int[] dice) {
        if (sixes != -1) {
            return false;
        }
        int score = 0;
        for (int i : dice) {
            if (i == 6) {
                score += 6;
            }
        }
        sixes = score;
        return true;
    }

    public boolean scoreThreeOAK(int[] dice) {
        if (threeOAK != -1) {
            return false;
        }
        Arrays.sort(dice);
        int count = 1;
        for (int i = 1; i < 5; i++) {
            if (dice[i] == dice[i-1]) {
                count++;
                if (count >= 3) {
                    threeOAK = 3 * dice[i];
                    return true;
                }
            } else {
                count = 1;
            }
        }
        threeOAK = 0;
        return true;
    }

    public boolean scoreFourOAK(int[] dice) {
        if (fourOAK != -1) {
            return false;
        }
        Arrays.sort(dice);
        int count = 1;
        for (int i = 1; i < 5; i++) {
            if (dice[i] == dice[i-1]) {
                count++;
                if (count >= 4) {
                    fourOAK = 4 * dice[i];
                    return true;
                }
            } else {
                count = 1;
            }
        }
        fourOAK = 0;
        return true;
    }

    public boolean scoreFullHouse(int[] dice) {
        if (fullHouse != -1) {
            return false;
        }
        Arrays.sort(dice);
        if ((dice[0] == dice [1] && dice[1] == dice[2] && dice[3] == dice[4]) || (dice[0] == dice [1] && dice[2] == dice[3] && dice[3] == dice[4])) {
            fullHouse = 25;
            return true;
        }
        else fullHouse = 0;
        return true;
    }

    public boolean scoreSmallStraight(int[] dice) {
        if (smallStraight != -1) {
            return false;
        }
        String numList = "";
        for (int i : dice) {
            numList += i;
        }
        if ((numList.contains("1") && numList.contains("2") && numList.contains("3") && numList.contains("4"))
                || (numList.contains("2") && numList.contains("3") && numList.contains("4") && numList.contains("5"))
                || numList.contains("3") && numList.contains("4") && numList.contains("5") && numList.contains("6")) {
            smallStraight = 30;
            return true;
        }
        smallStraight = 0;
        return true;
    }

    public boolean scoreLargeStraight(int[] dice) {
        if (largeStraight != -1) {
            return false;
        }
        Arrays.sort(dice);
        if (dice[0] + 1 == dice[1] && dice[1] + 1 == dice[2] && dice[2] + 1 == dice[3] && dice[3] + 1 == dice[4]) {
            largeStraight = 40;
            return true;
        }
        largeStraight =0;
        return true;
    }

    public boolean scoreChance(int[] dice) {
        if (chance != -1) {
            return false;
        }
        int total = 0;
        for (int i : dice) {
            total += i;
        }
        chance = total;
        return true;
    }

    public boolean scoreYahtzee(int[] dice) {
        if (yahtzee != -1) {
            return false;
        }
        int diceVal = dice[0];
        for (int i : dice) {
            if (i != diceVal) {
                yahtzee = 0;
                return true;
            }
        }
        yahtzee = 50;
        return true;
    }

    public String validBoxes() {
        String valid = "";
        if (ones == -1) {
            valid += "ones\n";
        }
        if (twos == -1) {
            valid += "twos\n";
        }
        if (threes == -1) {
            valid += "threes\n";
        }
        if (fours == -1) {
            valid += "fours\n";
        }
        if (fives == -1) {
            valid += "fives\n";
        }
        if (sixes == -1) {
            valid += "sixes\n";
        }
        if (threeOAK == -1) {
            valid += "three of a kind\n";
        }
        if (fourOAK == -1) {
            valid += "four of a kind\n";
        }
        if (fullHouse == -1) {
            valid += "full house\n";
        }
        if (smallStraight == -1) {
            valid += "small straight\n";
        }
        if (largeStraight == -1) {
            valid += "large straight \n";
        }
        if (yahtzee == -1) {
            valid += "yahtzee\n";
        }
        if (chance == -1) {
            valid += "chance\n";
        }
        return valid;
    }

    @Override
    public String toString() {
        String formattedScorecard = "";
        if (ones == -1) {
            formattedScorecard += "Ones: 0\n";
        } else {
            formattedScorecard += "Ones: " + ones + "\n";
        }
        if (twos == -1) {
            formattedScorecard += "Twos: 0\n";
        } else {
            formattedScorecard += "Twos: " + twos + "\n";
        }
        if (threes == -1) {
            formattedScorecard += "Threes: 0\n";
        } else {
            formattedScorecard += "Threes: " + threes + "\n";
        }
        if (fours == -1) {
            formattedScorecard += "Fours: 0\n";
        } else {
            formattedScorecard += "Fours: " + fours + "\n";
        }
        if (fives == -1) {
            formattedScorecard += "Fives: 0\n";
        } else {
            formattedScorecard += "Fives: " + fives + "\n";
        }
        if (sixes == -1) {
            formattedScorecard += "Sixes: 0\n";
        } else {
            formattedScorecard += "Sixes: " + sixes + "\n";
        }
        if (threeOAK == -1) {
            formattedScorecard += "Three of a Kind: 0\n";
        } else {
            formattedScorecard += "Three of a Kind: " + threeOAK + "\n";
        }
        if (fourOAK == -1) {
            formattedScorecard += "Four of a Kind: 0\n";
        } else {
            formattedScorecard += "Four of a Kind: " + fourOAK + "\n";
        }
        if (fullHouse == -1) {
            formattedScorecard += "Full House: 0\n";
        } else {
            formattedScorecard += "Full House: " + fullHouse + "\n";
        }
        if (smallStraight == -1) {
            formattedScorecard += "Small Straight: 0\n";
        } else {
            formattedScorecard += "Small Straight: " + smallStraight + "\n";
        }
        if (largeStraight == -1) {
            formattedScorecard += "Large Straight: 0\n";
        } else {
            formattedScorecard += "Large Straight: " + largeStraight + "\n";
        }
        if (yahtzee == -1) {
            formattedScorecard += "Yahtzee: 0\n";
        } else {
            formattedScorecard += "Yahtzee: " + yahtzee + "\n";
        }
        if (chance == -1) {
            formattedScorecard += "Chance: 0\n";
        } else {
            formattedScorecard += "Chance: " + chance + "\n";
        }
        formattedScorecard += "Total Score: " + this.getScore();
        return formattedScorecard;
    }
}
