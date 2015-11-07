package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DroidStrike extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {

		InputProcessor ip = new InputProcessor();
		Gdx.input.setInputProcessor(ip);
		Gdx.input.setCatchBackKey(true);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
        batch.dispose();
		img.dispose();
    }

}
