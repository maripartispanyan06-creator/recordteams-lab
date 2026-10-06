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
}
