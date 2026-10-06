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
    public static void sortTeams() {
        int teamCount = 0;
        for (int i = 0; i < compets.length; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (compets[i].getName().equals(compets[j].getName())) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                teamCount++;
            }
        }

        String[] teams = new String[teamCount];
        int[] totalScores = new int[teamCount];

        int index = 0;
        for (int i = 0; i < compets.length; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (compets[i].getName().equals(compets[j].getName())) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                teams[index] = compets[i].getName();
                for (int j = 0; j < compets.length; j++) {
                    if (compets[i].getName().equals(compets[j].getName())) {
                        totalScores[index] += compets[j].getScore();
                    }
                }

                index++;
            }
        }

        for (int i = 0; i < teamCount - 1; i++) {
            for (int j = 0; j < teamCount - 1 - i; j++) {
                if (totalScores[j] < totalScores[j + 1]) {
                    int tempScore = totalScores[j];
                    totalScores[j] = totalScores[j + 1];
                    totalScores[j + 1] = tempScore;

                    String tempTeam = teams[j];
                    teams[j] = teams[j + 1];
                    teams[j + 1] = tempTeam;
                }
            }
        }

        System.out.println("\nTeams by place:");

        for (int i = 0; i < teamCount; i++) {
            System.out.println(
                    (i + 1) + ". "
                            + teams[i]
                            + " - "
                            + totalScores[i]
                            + " points"
            );
        }
    }
}
