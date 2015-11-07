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

import java.util.ArrayList;

public class GameScreen implements Screen {

    final DroidStrike game;
    ArrayList<Player> bullets;

    OrthographicCamera camera;

    private SpriteBatch batch;

    private TextureRegion region;
    private TextureRegion bull;
    private Texture textur;
    private Sprite sprite;
    private Texture texture;

    private TextureRegion regionDown;
    private Sprite spriteDown;
    private Texture textureDown;

    private TextureRegion regionUp;
    private Sprite spriteUp;
    private Texture textureUp;

    private TextureRegion regionLeft;
    private Sprite spriteLeft;
    private Texture textureLeft;

    private Player player;

    public GameScreen (final DroidStrike game) {
        this.game = game;
        this.player = new Player();
        this.batch = new SpriteBatch();
<<<<<<< HEAD
        this.texture = new Texture(Gdx.files.internal("westdrone.png"));
		this.textureDown = new Texture(Gdx.files.internal("southdrone.png"));
		this.textureUp = new Texture(Gdx.files.internal("northdrone.png"));
		this.textureLeft = new Texture(Gdx.files.internal("eastdrone.png"));
=======
        this.texture = new Texture(Gdx.files.internal("drone.png"));
        this.textur = new Texture(Gdx.files.internal("bullet.png"));
>>>>>>> d5636771643a3dc387c0970bf2222a9a4174612b
        this.sprite = new Sprite(this.texture);
        region = new TextureRegion(texture);
        bull = new TextureRegion(bull);
        sprite.setPosition(0, 0);
        this.spriteDown = new Sprite(this.textureDown);
        regionDown = new TextureRegion(textureDown);
        spriteDown.setPosition(0, 0);

        this.spriteUp = new Sprite(this.textureUp);
        regionUp = new TextureRegion(textureUp);
        spriteUp.setPosition(0, 0);

        this.spriteLeft= new Sprite(this.textureLeft);
        regionLeft = new TextureRegion(textureLeft);
        spriteLeft.setPosition(0, 0);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float ydir = Gdx.input.getAccelerometerY(), xdir = Gdx.input.getAccelerometerX();

        player.setDirection(ydir, -1*xdir);

        player.move(delta);
		player.speed = 10;

        for(int i = 0; i < bullets.size(); i++) {
            bullets.remove(i);
        }

        if (Gdx.input.isTouched()) {
            Player bullet = new Player();
            bullet.setDirection(player.direction.x, player.direction.y);
            bullet.position.x = player.position.x;
            bullet.position.y = player.position.y;
            bullets.add(bullet);
            for (Player b: bullets) {
                b.move(delta);
            }
        }

        batch.begin();

        for(Player b: bullets) {
            batch.draw(bull, b.position.x, b.position.y);
        }

		if (xdir < 0 && xdir > ydir)
        	batch.draw(region, player.position.x - sprite.getWidth()/2f, player.position.y);
		else if (xdir > 0 && xdir > ydir)
        	batch.draw(regionLeft, player.position.x - spriteLeft.getWidth()/2f, player.position.y);
		else if (ydir < 0 && ydir > xdir)
        	batch.draw(regionUp, player.position.x - spriteUp.getWidth()/2f, player.position.y);
		else
			batch.draw(regionDown, player.position.x - spriteDown.getWidth()/2f, player.position.y);

        batch.end();
        camera.update();
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
        batch.dispose();
        textur.dispose();
        texture.dispose();
    }
}

