package compet;

import java.util.Scanner;

public class Competitions {
    private String name;
    private String type;
    private int score;

    @Override
    public String toString() {
        return String.format("Name is %s, type is %s, score is %d",this.name, this.type, this.score);
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getScore(){
        return this.score;
    }

    public void setName(String name){
        if (!name.isEmpty()){
            this.name=name;
        }
        else System.out.println("error");
    }
    public void setType(String type){
        if (!type.isEmpty()){
            this.type=type;
        }
        else System.out.println("error");
    }
    public void setScore(int score){
        if (!(score<0)){
            this.score=score;
        }
        else System.out.println("error");
    }

    public Competitions(String name, String type, int score){
        this.setName(name);
        setType(type);
        this.setScore(score);
    }
    public Competitions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input name");
        String name = sc.nextLine();
        System.out.println("input type");
        String type = sc.nextLine();
        System.out.println("input score");
        int score = sc.nextInt();
        this.setName(name);
        setType(type);
        this.setScore(score);
    }

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


    public static void fillList() {
        System.out.println("how many teams do you wanna write?");
        Scanner sc = new Scanner(System.in);
        int nom = sc.nextInt();
        compets = new Competitions[nom];
        for (int i = 0; i < compets.length; i++) {
            compets[i] = new Competitions();
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
