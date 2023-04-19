package at.sur.games.wintergame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;


import java.util.ArrayList;
import java.util.List;

public class MainGame extends BasicGame {
    private List<Actor> actors;
    private PlayerActor player;

    private List<Observer> observers;

    public MainGame(String title) {
        super(title);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) throws SlickException {
        // gezeichnet
        for (Actor actor: this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        // 1 mal aufgerufen am Beginn des Spieles
        this.actors = new ArrayList<>();
        this.player = new PlayerActor();

        MoveStrategy mr1 = new MoveRight(0, 0, 0.3f);
        MoveStrategy mr2 = new MoveLeft(500, 100, 0.2f);
        MoveStrategy mr3 = new MoveRight(100, 200, 0.1f);
        MoveStrategy mr4 = new MoveRight(100, 300, 0.1f);

        this.actors.add (new CircleActor(mr1));
        this.actors.add (new CircleActor(mr2));
        this.actors.add (new CircleActor(mr3));
        this.actors.add (new CircleActor(mr4));
        this.actors.add (new PlayerActor());

        CircleActor c4 = new CircleActor(mr3);

        this.actors.add(c4);

        this.actors.add(player);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // delta = Zeit seit dem letzten Aufruf
        for (Actor actor: this.actors) {
            actor.update(gc, delta);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new MainGame("Winter Game"));
            container.setDisplayMode(800,600,false);
            container.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
