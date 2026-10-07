package compet;

import java.util.Scanner;

public class TeamsService {
    private static Competitions[] compets = {
            new Competitions("Russia", "futbol", 10),
            new Competitions("Russia", "figure skating", 13),
            new Competitions("Russia", "tennis", 18),
            new Competitions("Armenia", "futbol", 15),
            new Competitions("Armenia", "tennis", 13),
            new Competitions("Armenia", "figure skating", 11),
            new Competitions("Argentina", "tennis", 14),
            new Competitions("Argentina", "futbol", 17),
            new Competitions("Argentina", "figure skating", 6),
            new Competitions("Spain", "figure skating", 9),
            new Competitions("Spain", "tennis", 12),
            new Competitions("Spain", "futbol", 18),
            new Competitions("China", "futbol", 12),
            new Competitions("China", "tennis", 11),
            new Competitions("China", "figure skating", 14),
    };

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
    public static void fillList() {
        System.out.println("how many teams do you wanna write?");
        Scanner sc = new Scanner(System.in);
        int nom = sc.nextInt();
        compets = new Competitions[nom];
        for (int i = 0; i < compets.length; i++) {
            compets[i] = new Competitions();
        }
    }
    public static void findByName(){
        System.out.println("input team's name for find");
        Scanner sc = new Scanner(System.in);
        String findname = sc.nextLine();
        for (int i = 0; i < compets.length; i++) {
            if (compets[i].getName().equals(findname)) {
                System.out.println(compets[i]);
            }
        }
    }
    public static void countTeams(){
        int countTeam = 0;
        for (int i = 0; i < compets.length; i++){
            boolean seen = false;
            for (int j = 0; j < i; j++) {
                if (compets[i].getName().equals(compets[j].getName())) {
                    seen = true;
                    break;
                }
            }
            if (!seen) countTeam++;
        }
    }
}
