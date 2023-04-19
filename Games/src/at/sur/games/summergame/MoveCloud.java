package at.sur.games.summergame;

import org.newdawn.slick.*;

public class MoveCloud implements MoveStrategy{

    private float x, y, speed;
    private boolean MoveDirection;

    public MoveCloud(float x, float y, float speed) {
        super();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.MoveDirection = true;
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
        if (MoveDirection) {
            this.x += delta * speed;
        } else {
            this.x -= delta * speed;
        }

        if (this.x < -500 || this.x > 1000) {
            this.MoveDirection =! MoveDirection;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
