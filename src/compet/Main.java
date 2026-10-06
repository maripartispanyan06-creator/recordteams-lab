package compet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Выдать список победителей в каждом виде соревнований");
            System.out.println("4. Выдать команду, занявшую первое место в общем зачёте");
            System.out.println("5. Отсортировать список команд в зависимости от занятого места");
            System.out.println("6. Выход");
            System.out.println("Выберете пункт меню от 1 до 6");
            Scanner sc = new Scanner(System.in);
            int c = sc.nextInt();
            switch (c) {
                case 1: TeamsService.fillList(); break;
                case 2: TeamsService.printList(); break;
                case 3: TeamsService.winnerList(); break;
                case 4: TeamsService.winner(); break;
                case 5: TeamsService.sortTeams(); break;
                default: break cycle;
            }

        }
    }
}