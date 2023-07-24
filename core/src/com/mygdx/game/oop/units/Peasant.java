package com.mygdx.game.oop.units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(String name, int x, int y) {

        super(name, 100, "Peasant", 5, 0, x, y);
    }
    boolean busy = false;
    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> their) {
        if(health == 0){
            this.busy = true;
        }
    }
}
