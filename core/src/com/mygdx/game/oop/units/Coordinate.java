package com.mygdx.game.oop.units;

public class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double calcDistanse(Coordinate point){
        int dx = point.x - x;
        int dy = point.y - y;
        return Math.sqrt((dx*dx)+(dy*dy));
    }
}
