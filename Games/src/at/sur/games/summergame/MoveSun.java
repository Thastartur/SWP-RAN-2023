package at.sur.games.summergame;

import org.newdawn.slick.*;

public class MoveSun implements MoveStrategy{

    private float x, y, speed;

    public MoveSun(float x, float y, float speed) {
        super();
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void update(int delta) {
        this.x += delta * speed;

        if (this.x > 800) {
                this.x = -200;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
