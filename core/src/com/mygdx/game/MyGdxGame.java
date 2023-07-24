package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.oop.Main;
import com.mygdx.game.oop.units.*;

import java.util.ListIterator;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;

	Main game;
	Music music;
	private boolean clk = true;


	@Override
	public void create () {
		game = new Main();

		batch = new SpriteBatch();
		fon = new Texture("fons/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-01.mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();

		crossBowMan = new Texture("pers/CrossBowMan.png");
		mage = new Texture("pers/Mage.png");
		monk = new Texture("pers/Monk.png");
		peasant = new Texture("pers/Peasant.png");
		rouge = new Texture("pers/Rouge.png");
		sniper = new Texture("pers/Sniper.png");
		spearMan =  new Texture("pers/SpearMan.png");
	}

	@Override
	public void render () {
		if(Gdx.input.isTouched() & clk){
			clk = false;
			game.main();
		}
		if(!Gdx.input.isTouched() & !clk) clk = true;

		ScreenUtils.clear(1, 1, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int dx = Gdx.graphics.getWidth()/12;
		int dy = Gdx.graphics.getHeight()/15;
		ListIterator<BaseHero> iterator = game.team2.listIterator(game.team2.size());
		while (iterator.hasPrevious()){
			BaseHero hero = iterator.previous();
			if (hero.health <= 0) continue;
			int m = 1;
			if(game.team2.contains(hero)) m = 1;
			if (hero instanceof Archer) batch.draw(crossBowMan, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, crossBowMan.getWidth()*m, crossBowMan.getHeight());
			if (hero instanceof Bandit) batch.draw(rouge, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, rouge.getWidth()*m, rouge.getHeight());
			if (hero instanceof Mage) batch.draw(mage, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, mage.getWidth()*m, mage.getHeight());
			if (hero instanceof Monk) batch.draw(monk, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, monk.getWidth()*m, monk.getHeight());
			if (hero instanceof Peasant) batch.draw(peasant, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, peasant.getWidth()*m, peasant.getHeight());
			if (hero instanceof Pikeman) batch.draw(spearMan, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, spearMan.getWidth()*m, spearMan.getHeight());
			if (hero instanceof Sniper) batch.draw(sniper, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, sniper.getWidth()*m, sniper.getHeight());

		}
		iterator = game.team1.listIterator(game.team1.size());
		while (iterator.hasPrevious()){
			BaseHero hero = iterator.previous();
			if (hero.health <= 0) continue;
			int m = 1;
			if(game.team1.contains(hero)) m = -1;
			if (hero instanceof Archer) batch.draw(crossBowMan, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, crossBowMan.getWidth()*m, crossBowMan.getHeight());
			if (hero instanceof Bandit) batch.draw(rouge, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, rouge.getWidth()*m, rouge.getHeight());
			if (hero instanceof Mage) batch.draw(mage, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, mage.getWidth()*m, mage.getHeight());
			if (hero instanceof Monk) batch.draw(monk, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, monk.getWidth()*m, monk.getHeight());
			if (hero instanceof Peasant) batch.draw(peasant, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, peasant.getWidth()*m, peasant.getHeight());
			if (hero instanceof Pikeman) batch.draw(spearMan, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, spearMan.getWidth()*m, spearMan.getHeight());
			if (hero instanceof Sniper) batch.draw(sniper, hero.getCoords()[0]*dx, hero.getCoords()[1]*dy, sniper.getWidth()*m, sniper.getHeight());

		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		music.dispose();
		crossBowMan.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		rouge.dispose();
		sniper.dispose();
		spearMan.dispose();
	}
}
