package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;



public class MainMenuScreen implements Screen {

    final DroidStrike game;

    OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private float screenWidth;
    private float screenHeight;


    public MainMenuScreen(final DroidStrike gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("../data/welcome.png"));
        camera.update();
        getScreenSize();
        batch.begin();
        batch.draw( texture, screenWidth, screenHeight);
        batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }
    public void getScreenSize(){
         this.screenWidth = (Gdx.graphics.getWidth()/2)-150;
         this.screenHeight = (Gdx.graphics.getHeight()/2);
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

    }
}

