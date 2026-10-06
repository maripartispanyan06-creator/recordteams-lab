package compet;

public class TeamsService {
    public static void printList(){
        for (Competitions c: compets) System.out.println(c);
    }
    public static void winnerList() {
        for (int i = 0; i < compets.length; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (compets[i].getType().equals(compets[j].getType())) {
                    alreadySeen = true;
                    break;
                }
            }
            if (alreadySeen) {
                continue;
            }
            int winnerIndex = i;

            for (int j = i + 1; j < compets.length; j++) {
                if (compets[j].getType().equals(compets[i].getType())) {
                    if (compets[j].getScore() > compets[winnerIndex].getScore()) {
                        winnerIndex = j;
                    }
                }
            }
            System.out.println(
                    compets[winnerIndex].getName()
                            + " won "
                            + compets[winnerIndex].getType()
                            + " with "
                            + compets[winnerIndex].getScore()
                            + " points"
            );
        }
    }
    public static void winner() {
        int winnerIndex = 0;
        int maxScore = 0;
        for (int i = 0; i < compets.length; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (compets[i].getName().equals(compets[j].getName())) {
                    alreadySeen = true;
                    break;
                }
            }

            if (alreadySeen) {
                continue;
            }

            int totalScore = 0;

            for (int j = 0; j < compets.length; j++) {
                if (compets[i].getName().equals(compets[j].getName())) {
                    totalScore += compets[j].getScore();
                }
            }
            if (totalScore > maxScore) {
                maxScore = totalScore;
                winnerIndex = i;
            }
        }

        System.out.println("\nWinner of the overall competition:");
        System.out.println(
                compets[winnerIndex].getName()
                        + " - "
                        + maxScore
                        + " points"
        );
    }
}
