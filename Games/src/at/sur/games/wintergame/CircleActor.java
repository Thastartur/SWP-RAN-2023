package at.sur.games.wintergame;

import org.newdawn.slick.*;

public class CircleActor implements Actor, Observer{
    private MoveStrategy moveStrategy;
    private Color color;

    public CircleActor(MoveStrategy mr) {
        super();
        this.moveStrategy = mr;
        this.color = Color.white;
    }

    public void update(GameContainer gc, int delta) {
        moveStrategy.update(delta);
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 20, 20);
        graphics.setColor(Color.white);
    }

    @Override
    public void inform() {
        this.color = Color.pink;
    }
}
