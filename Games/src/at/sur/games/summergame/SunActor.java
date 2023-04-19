package at.sur.games.summergame;

import at.sur.games.summergame.MoveStrategy;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SunActor implements Actor{

    private MoveStrategy moveStrategy;
    private List<Observer> observers;

    public SunActor(MoveStrategy mr) {
        super();
        this.moveStrategy = mr;

        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void update(GameContainer gc, int delta) {
        moveStrategy.update(delta);

        if (this.moveStrategy.getX() > 50) {
            for (Observer observer : observers) {
                observer.inform();
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 100, 100);
    }
}
