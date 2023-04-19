package at.sur.games.summergame;

import org.newdawn.slick.*;

public class MoveRain implements MoveStrategy, Observer{

    private float x, y, speed;

    public MoveRain(float x, float y, float speed) {
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
        this.y += delta * speed;

        if (this.y > 800) {
            this.y = -200;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void inform() {
        this.y += 1;
    }
}
