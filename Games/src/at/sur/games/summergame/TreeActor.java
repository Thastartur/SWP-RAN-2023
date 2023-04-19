package at.sur.games.summergame;

import at.sur.games.summergame.MoveStrategy;
import org.newdawn.slick.*;

public class TreeActor implements Actor, Observer{

    private MoveStrategy moveStrategy;
    private Color color;
    private float size = 30;

    public TreeActor(MoveStrategy mr) {
        super();
        this.moveStrategy = mr;
    }

    @Override
    public void update(GameContainer gc, int delta) {
        moveStrategy.update(delta);

        if (gc.getInput().isKeyDown(Input.KEY_SPACE)) {
            this.size += 0.01;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.moveStrategy.getX() , this.moveStrategy.getY(), size, size);
        graphics.setColor(Color.white);
    }

    @Override
    public void inform() {
        this.color = Color.green;
    }
}
