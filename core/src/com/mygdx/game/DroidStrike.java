package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class DroidStrike extends Game {
    private static DroidStrike gameinstance;

	private MainMenuScreen menuScreen;
    private GameScreen gameScreen;

	@Override
	public void create () {
		menuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);


		this.setScreen(menuScreen);
	}

	/*
	@Override
	public void render () {
		super.render();
	}
	*/

 	@Override
    public void dispose() {
        super.dispose();
        menuScreen.dispose();
        gameScreen.dispose();
    }
}

