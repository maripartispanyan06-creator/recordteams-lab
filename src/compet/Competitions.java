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







}
