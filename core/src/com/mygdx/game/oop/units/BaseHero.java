package com.mygdx.game.oop.units;

import java.util.ArrayList;

public abstract class BaseHero implements Interface {
    public String name;
    public int health;
    public String type;
    public int queue; // очередь

    public int getQueue() {
        return queue;
    }

    public int baseDamage;
    Coordinate playgraund;

    public BaseHero(String name, int health, String type, int queue, int baseDamage, int x, int y) {
        this.name = name;
        this.health = health;
        this.type = type;
        this.queue = queue;
        this.baseDamage = baseDamage;
        playgraund = new Coordinate(x, y);
    }

    protected BaseHero findEnemy(ArrayList<BaseHero> enemies) {
        double min = 1000;
        int count = 0;
        for (int i = 0; i < enemies.size(); i++) {
            if (playgraund.calcDistanse(enemies.get(i).playgraund) < min & enemies.get(i).health > 0) {
                min = playgraund.calcDistanse(enemies.get(i).playgraund);
                count = i;
            }
        }
        return enemies.get(count);
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }

    public int[] getCoords() {
        int[] coords = {playgraund.x, playgraund.y};
        return coords;
    }

    public String getInfo() {
        return String.format("%s, %s, \u2661: %d, x: %d, y: %d", name, type, health, playgraund.x, playgraund.y);
    }

    protected void getDamage(float damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

}
