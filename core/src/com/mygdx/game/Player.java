package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
/**
 * Created by Jayant on 07/11/2015.
 */
public class Player {
    protected Integer speed;
    protected Vector2 direction, position;
    protected boolean isAttacking, isAlive;

    public Player(){

        this.direction = new Vector2(0,0); // Default facing south
        this.position = new Vector2(0,0);
        this.speed = 1; 					// Affects move speed and attack speed (would also affect animation frame duration)
        this.isAlive = true;
        this.isAttacking = false;
    }

    public void move(float delta){
        // Moves the character.

            this.position.x += 10*this.speed*this.direction.x*delta;
            this.position.y += 10*this.speed*this.direction.y*delta;

			if (position.x < 0f) this.position.x = 800f;
			else if (position.x > 800f) this.position.x = 0f;

			if (position.y < 0f) this.position.y = 480f;
			else if (position.y > 480f) this.position.y = 0f;
    }

    public void setDirection(float x, float y) {
        //Pass accelerometer data in.

        this.direction.x = x;
        this.direction.y = y;
    }

    public void setAttacking(boolean bool) {

        this.isAttacking = bool;
    }
}
