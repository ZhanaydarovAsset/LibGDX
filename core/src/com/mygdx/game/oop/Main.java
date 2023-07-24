package com.mygdx.game.oop;

import com.mygdx.game.oop.units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> allUnits = new ArrayList<>();
    public static ArrayList<BaseHero> team1 = new ArrayList<>();
    public static ArrayList<BaseHero> team2 = new ArrayList<>();

    public Main() {
        for (int i = 0; i < 11; i++) {
            int k = new Random().nextInt(4);
            switch (k) {
                case 0:
                    team1.add(new Monk("Li", 10, i));
                    break;
                case 1:
                    team1.add(new Sniper("Saske", 10, i));
                    break;
                case 2:
                    team1.add(new Bandit("Loki", 10, i));
                    break;
                default:
                    team1.add(new Peasant("Holop", 10, i));
            }
        }

        for (int i = 0; i < 11; i++) {
            int k = new Random().nextInt(4);
            switch (k) {
                case 0:
                    team2.add(new Mage("Alisa", 1, i));
                    break;
                case 1:
                    team2.add(new Archer("Masha", 1, i));
                    break;
                case 2:
                    team2.add(new Pikeman("Gektor", 1, i));
                    break;
                default:
                    team2.add(new Peasant("Ivan", 1, i));
            }
        }

        allUnits.addAll(team1);
        allUnits.addAll(team2);

        allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero t0, BaseHero t1) {
                return t1.getQueue() - t0.getQueue();
            }
        });

    }

    public void main() {


//        Scanner enter = new Scanner(System.in);
//        while (true) {
//            View.view();
//            enter.nextLine();
            for (BaseHero item : allUnits) {
                if (team1.contains(item)) {
                    item.step(team2, team1);
                } else {
                    item.step(team1, team2);
                }
            }
            if (teamLose(team1)) {
                System.out.println("Team #2 win");
//                break;
            }
            if (teamLose(team2)) {
                System.out.println("Team #1 win");
//                break;
            }
//        }
    }

    public static boolean teamLose(ArrayList<BaseHero> teams) {
        int count = 0;
        for (BaseHero item : teams) {
            if (item.health != 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
}