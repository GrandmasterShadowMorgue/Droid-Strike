package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;

public class GameScreen implements Screen {

    final DroidStrike game;
    ArrayList<Player> bullets;
    private TiledMapRenderer mapRenderer;
    OrthographicCamera camera;

    private SpriteBatch batch;
    private TiledMap map;
    private TextureRegion bull;
    private Texture bulletTexture;

    private TextureRegion region;
    private Texture texture;

    private TextureRegion regionDown;
    private Texture textureDown;

    private TextureRegion regionUp;
    private Texture textureUp;

    private TextureRegion regionLeft;
    private Texture textureLeft;

    private Player player;

    public GameScreen (final DroidStrike game) {
        this.game = game;
        this.player = new Player();
        this.batch = new SpriteBatch();
        this.map = new TmxMapLoader().load("london.tmx");
        this.texture = new Texture(Gdx.files.internal("westdrone.png"));
		this.textureDown = new Texture(Gdx.files.internal("southdrone.png"));
		this.textureUp = new Texture(Gdx.files.internal("northdrone.png"));
		this.textureLeft = new Texture(Gdx.files.internal("eastdrone.png"));
        this.bulletTexture = new Texture(Gdx.files.internal("bullet.png"));
        this.mapRenderer = new OrthogonalTiledMapRenderer(this.map);
        mapRenderer.setView(camera);
        bull = new TextureRegion(bulletTexture);

        region = new TextureRegion(texture);

        regionDown = new TextureRegion(textureDown);

        regionUp = new TextureRegion(textureUp);

        regionLeft = new TextureRegion(textureLeft);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

		bullets = new ArrayList<Player>();
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
			if (bullets.size() > 50 || bullets.get(i).position.x > 800
					|| bullets.get(i).position.y > 480
					|| bullets.get(i).position.y < 0
					|| bullets.get(i).position.x < 0)

            bullets.remove(i);
			else bullets.get(i).move(delta);
        }

        if (Gdx.input.isTouched()) {
            Player bullet = new Player();
            bullet.setDirection(player.direction.x, player.direction.y);
            bullet.position.x = player.position.x;
            bullet.position.y = player.position.y;
            bullet.speed = 100;
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
        	batch.draw(region, player.position.x - texture.getWidth()/2f, player.position.y);
		else if (xdir > 0 && xdir > ydir)
        	batch.draw(regionLeft, player.position.x - textureLeft.getWidth()/2f, player.position.y);
		else if (ydir < 0 && ydir > xdir)
        	batch.draw(regionUp, player.position.x - textureUp.getWidth()/2f, player.position.y);
		else
			batch.draw(regionDown, player.position.x - textureDown.getWidth()/2f, player.position.y);

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
        bulletTexture.dispose();
        texture.dispose();
        textureUp.dispose();
        textureDown.dispose();
        textureLeft.dispose();
    }
}

