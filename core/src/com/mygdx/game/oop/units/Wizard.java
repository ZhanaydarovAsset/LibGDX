package com.mygdx.game.oop.units;

import java.util.ArrayList;

public abstract class Wizard extends BaseHero{
    public Wizard(String name, int health, String type, int queue, int baseDamage,  int x, int y, int healing) {
        super(name, health, type, queue, baseDamage, x, y);
        this.healing = healing;
    }

    int healing;
    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> their) {
        if(this.health > 0){
            for(BaseHero item : their){
                if(item.health < 90 & item.health != 0){
                    item.health += healing;
                    return;
                }
            }
            BaseHero temp =  findEnemy(enemies);
            temp.getDamage(((float) (healing)));
        }
    }
}
