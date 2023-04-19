package at.sur.games.summergame;

import at.sur.games.summergame.MoveStrategy;
import org.newdawn.slick.*;

public class RainActor  implements Actor{

    private MoveStrategy moveStrategy;
    private Color color;

    public RainActor(MoveStrategy mr) {
        super();
        this.moveStrategy = mr;
    }

    @Override
    public void update(GameContainer gc, int delta) {
        moveStrategy.update(delta);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(moveStrategy.getX(), moveStrategy.getY(), 10, 10);
        graphics.setColor(Color.gray);
    }
}
