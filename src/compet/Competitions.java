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









}
