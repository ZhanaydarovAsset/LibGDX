package com.mygdx.game.oop.units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero{
    public Infantry(String name, int health, String type, int queue, int baseDamage, int x, int y) {
        super(name, health, type, queue, baseDamage, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> their) {
        if(health <= 0) return;
        BaseHero temp =  findEnemy(enemies);
        if(this.playgraund.calcDistanse(temp.playgraund) < 2){
            temp.getDamage(this.baseDamage);
            return;
        }

        Coordinate tempCoord = new Coordinate(playgraund.x, playgraund.y);
        if(Math.abs(this.playgraund.x-temp.playgraund.x)>Math.abs(this.playgraund.y - temp.playgraund.y)){
            if(this.playgraund.x > temp.playgraund.x){
                tempCoord.x -= 1;
            }
            else {
                tempCoord.x += 1;
            }
        }
        else{
            if(this.playgraund.y > temp.playgraund.y){
                tempCoord.y -= 1;
            }
            else {
                tempCoord.y += 1;
            }
        }
        boolean flag = false;
        for(BaseHero item : their){
            if(item.playgraund.x == tempCoord.x & item.playgraund.y == tempCoord.y){
                return;
            }
        }
        this.playgraund.x = tempCoord.x;
        this.playgraund.y = tempCoord.y;
    }
}
