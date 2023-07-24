package com.mygdx.game.oop.units;

import java.util.ArrayList;

public abstract class Shooters extends BaseHero{
    public Shooters(String name, int health, String type, int queue, int baseDamage, int shoots,  int x, int y) {
        super(name, health, type, queue, baseDamage, x, y);
        this.shoots = shoots;
    }
    protected int shoots;

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> their) {
        if(this.health <= 0 || this.shoots == 0) return;
        BaseHero temp =  findEnemy(enemies);
        temp.getDamage(this.baseDamage);
        for(BaseHero item : their) {
            if (item.type.contains("Peasant") && !((Peasant)(item)).busy && item.health > 0){
                ((Peasant)(item)).busy = true;
                return;
            }
        }
        this.shoots--;
    }
}
