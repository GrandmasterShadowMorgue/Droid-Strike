package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {

    final DroidStrike game;

	public static Texture backgroundTexture;
    public static Sprite sprite;
    private SpriteBatch spriteBatch;

    OrthographicCamera camera;

    public MainMenuScreen(final DroidStrike gam) {
        game = gam;

		backgroundTexture = new Texture("images/menu.jpg");
        sprite =new Sprite(backgroundTexture);
		spriteBatch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
		spriteBatch = new SpriteBatch();
    }

	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();
   		spriteBatch.setProjectionMatrix(camera.combined);
        sprite.draw(spriteBatch);
		spriteBatch.end();

        camera.update();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
			dispose();
        }
 	}

	@Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
		spriteBatch.dispose();
		backgroundTexture.dispose();
    }
}

