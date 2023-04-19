package at.sur.games.summergame;

import org.newdawn.slick.*;

public interface MoveStrategy {
    public float getX();
    public float getY();
    public void update(int delta);
}
