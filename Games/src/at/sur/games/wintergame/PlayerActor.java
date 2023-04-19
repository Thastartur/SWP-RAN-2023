package at.sur.games.wintergame;

import org.newdawn.slick.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

public class PlayerActor implements Actor{

    private float x, y, speed;
    private List<Observer> observers;

    public PlayerActor() {
        this.x = 300;
        this.y = 300;
        this.speed = 1f;
        this.observers = new ArrayList<>();
    }

    public void addCircleActor(CircleActor circleActor) {
        this.observers.add(circleActor);
    }

    public void draw(Graphics graphics) {
        graphics.fillRect(this.x, this.y, 50, 50);
    }

    public void move(GameContainer gc, int delta) {
        if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x -= (float)delta * speed;
            System.out.println("left: x : " + this.x);
        }

        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x += delta * speed;
        }

        if(this.x>200) {
            for (Observer observer : observers) {
                observer.inform();
            }
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.speed, 20,20);
    }
}
