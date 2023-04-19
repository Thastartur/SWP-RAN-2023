package at.sur.games.summergame;

import at.sur.games.summergame.*;
import at.sur.games.summergame.Actor;
import at.sur.games.summergame.MoveStrategy;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;


import java.util.ArrayList;
import java.util.List;

public class MainGame extends BasicGame{

    private List<Actor> actors;

    public MainGame(String title) {
        super(title);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // 1 mal aufgerufen am Beginn des Spieles
        this.actors = new ArrayList<>();

        MoveStrategy mr10 = new MoveRain(200, -20, 0.01f);

        RainActor r1 = new RainActor(mr10);

        MoveStrategy mr1 = new MoveSun(0, 50, 0.05f);
        MoveStrategy mr2 = new MoveCloud(500, 150, 0.2f);
        MoveStrategy mr3 = new MoveSun(100, 175, 0.1f);
        MoveStrategy mr4 = new MoveCloud(200, 200, 0.1f);

        MoveStrategy mr5 = new MoveCloud(70, 500, 0f);
        MoveStrategy mr6 = new MoveCloud(140, 510, 0f);
        MoveStrategy mr7 = new MoveCloud(210, 490, 0f);
        MoveStrategy mr8 = new MoveCloud(280, 500, 0f);
        MoveStrategy mr9 = new MoveCloud(350, 515, 0f);
        MoveStrategy mr11 = new MoveCloud(420, 505, 0f);
        MoveStrategy mr12 = new MoveCloud(490, 495, 0f);
        MoveStrategy mr13 = new MoveCloud(560, 500, 0f);
        MoveStrategy mr14 = new MoveCloud(630, 495, 0f);
        MoveStrategy mr15 = new MoveCloud(700, 515, 0f);

        CloudActor c1 = new CloudActor(mr10);

        this.actors.add (c1);

        SunActor s1 = new SunActor(mr1);

        TreeActor t1 = new TreeActor(mr5);
        TreeActor t2 = new TreeActor(mr6);
        TreeActor t3 = new TreeActor(mr7);
        TreeActor t4 = new TreeActor(mr8);
        TreeActor t5 = new TreeActor(mr9);
        TreeActor t6 = new TreeActor(mr11);
        TreeActor t7 = new TreeActor(mr12);
        TreeActor t8 = new TreeActor(mr13);
        TreeActor t9 = new TreeActor(mr14);
        TreeActor t10 = new TreeActor(mr15);

        this.actors.add (s1);
        this.actors.add (r1);

        this.actors.add (new CloudActor(mr2));
        this.actors.add (new CloudActor(mr3));
        this.actors.add (new CloudActor(mr4));

        this.actors.add (t1);
        this.actors.add (t2);
        this.actors.add (t3);
        this.actors.add (t4);
        this.actors.add (t5);
        this.actors.add (t6);
        this.actors.add (t7);
        this.actors.add (t8);
        this.actors.add (t9);
        this.actors.add (t10);

        s1.addObserver(t1);
        s1.addObserver(t2);
        s1.addObserver(t3);
        s1.addObserver(t4);
        s1.addObserver(t5);
        s1.addObserver(t6);
        s1.addObserver(t7);
        s1.addObserver(t8);
        s1.addObserver(t9);
        s1.addObserver(t10);

        c1.addObserver((Observer) mr10);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // delta = Zeit seit dem letzten Aufruf
        for (Actor actor: this.actors) {
            actor.update(gc, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        // gezeichnet
        for (Actor actor: this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.sur.games.summergame.MainGame("Sommer Game"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
