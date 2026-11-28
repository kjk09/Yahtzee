//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    IO.println("Hello! Welcome to Yahtzee. Please enter number of players.");
    int playerCount;
    while (true) {
        String response = IO.readln();
        try {
            playerCount = Integer.parseInt(response);
            break;
        } catch (NumberFormatException e) {
            IO.println("Please enter a valid number.");
        }
    }
    Player[] players = new Player[playerCount];
    for (int i = 0; i < playerCount; i++) {
        IO.println("Please enter the player's name.");
        players[i] = new Player(IO.readln());
    }
    for (int turn = 0; turn < 13; turn++) {
        for (Player p : players) {
            IO.println("Player " + p.getName() + "'s turn. Current Scorecard:");
            IO.println(p);
            IO.println();
            Dice d = new Dice();
            IO.println("Initial roll:\n" + d);
            IO.println("Reroll dice? (yes/no)");
            if (IO.readln().equalsIgnoreCase("yes")) {
                IO.println("Input the indexes (1-5, separated by spaces) of dice to reroll.");
                String[] responseStr = IO.readln().split(" ");
                int[] response = new int[responseStr.length];
                for (int i = 0; i < responseStr.length; i++) {
                    response[i] = Integer.parseInt(responseStr[i]) - 1;
                }
                d.reroll(response);
                IO.println("New values:\n" + d);
                IO.println("Reroll again? (yes/no)");
                if (IO.readln().equalsIgnoreCase("yes")) {
                    IO.println("Input the indexes (1-5, separated by spaces) of dice to reroll.");
                    String[] rerollIndexesString = IO.readln().split(" ");
                    int[] rerollIndexes = new int[rerollIndexesString.length];
                    for (int i = 0; i < rerollIndexesString.length; i++) {
                        rerollIndexes[i] = Integer.parseInt(rerollIndexesString[i]) - 1;
                    }
                    d.reroll(rerollIndexes);
                    IO.println("New values:\n" + d);
                }
            }
            IO.println();
            IO.print("Choose an empty category to score roll in:\n" + p.validBoxes());
            boolean pickedValidBox = false;
            while (!pickedValidBox) {
                String scoreBoxPick = IO.readln();
                scoreBoxPick = scoreBoxPick.toLowerCase();
                switch (scoreBoxPick) {
                    case "ones":
                        if (!p.scoreOnes(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as ones for " + p.getOnes() + " points.");
                            break;
                        }
                    case "twos":
                        if (!p.scoreTwos(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as twos for " + p.getTwos() + " points.");
                            break;
                        }
                    case "threes":
                        if (!p.scoreThrees(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as threes for " + p.getThrees() + " points.");
                            break;
                        }
                    case "fours":
                        if (!p.scoreFours(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as fours for " + p.getFours() + " points.");
                            break;
                        }
                    case "fives":
                        if (!p.scoreFives(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as fives for " + p.getFives() + " points.");
                            break;
                        }
                    case "sixes":
                        if (!p.scoreSixes(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as sixes for " + p.getSixes() + " points.");
                            break;
                        }
                    case "three of a kind":
                        if (!p.scoreThreeOAK(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as three of a kind for " + p.getThreeOAK() + " points.");
                            break;
                        }
                    case "four of a kind":
                        if (!p.scoreFourOAK(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as four of a kind for " + p.getFourOAK() + " points.");
                            break;
                        }
                    case "full house":
                        if (!p.scoreFullHouse(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as full house for " + p.getFullHouse() + " points.");
                            break;
                        }
                    case "small straight":
                        if (!p.scoreSmallStraight(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as small straight for " + p.getSmallStraight() + " points.");
                            break;
                        }
                    case "large straight":
                        if (!p.scoreLargeStraight(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as large straight for " + p.getLargeStraight() + " points.");
                            break;
                        }
                    case "yahtzee":
                        if (!p.scoreYahtzee(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as Yahtzee for " + p.getYahtzee() + " points.");
                            break;
                        }
                    case "chance":
                        if (!p.scoreChance(d.getRoll())) {
                            IO.println("Error: Pick a valid category");
                            continue;
                        } else {
                            pickedValidBox = true;
                            IO.println("Scored as chance for " + p.getChance() + " points.");
                            break;
                        }
                    default:
                        IO.println("Error: Pick a valid category");
                }
            IO.println();
            }
        }
    }
    IO.println("All turns completed.");
    Player winner = null;
    int maxScore = Integer.MIN_VALUE;
    for (Player p : players) {
        if (p.getScore() > maxScore) {
            winner = p;
            maxScore = p.getScore();
        }
    }
    String winnerName;
    if (winner == null || winner.getName() == null) {
        winnerName = "null";
    } else {
        winnerName = winner.getName();
    }

    IO.println("Congratulations to the winner, " + winnerName + "!\nFinal scores:");
    for (Player p : players) {
        IO.println(p.getName() + ": " + p.getScore() + " points");
    }
    IO.println("Thank you for playing!");
}
