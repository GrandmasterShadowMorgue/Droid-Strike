package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen implements Screen {

    final DroidStrike game;

    OrthographicCamera camera;

    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion region;
    private Sprite sprite;
    private Player player;

    public GameScreen (final DroidStrike game) {
        this.game = game;
        this.player = new Player();
        this.batch = new SpriteBatch();
        this.texture = new Texture(Gdx.files.internal("drone.png"));
        this.sprite = new Sprite(this.texture);
        region = new TextureRegion(texture);
        sprite.setPosition(0, 0);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.setDirection(Gdx.input.getAccelerometerX(), Gdx.input.getAccelerometerY());
        System.out.println("X is :" + Gdx.input.getAccelerometerX());
        System.out.println("Y is :" + Gdx.input.getAccelerometerY());
        player.move(delta);

        batch.begin();
        batch.draw(region, player.position.x, player.position.y);
        batch.end();
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

    }
}

