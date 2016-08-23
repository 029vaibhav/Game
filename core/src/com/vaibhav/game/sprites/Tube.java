package com.vaibhav.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by vaibhav on 10/8/16.
 */
public class Tube {

    public static final int TUBE_WIDTH = 52;
    private static final int TUBE_GAP = 100; //opening between tubes
    private static final int LOWEST_OPENING = 120; //lowest position the top of the bottom tube can be, must be above 90 to be above ground level
    private static final int FLUCTUATION = 130;  //may adjust to keep top tube in view
    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Rectangle boundsTop, boundsBottom;

    private Random random;


    public Tube(float x) {

        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        random = new Random();
        posTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + LOWEST_OPENING + TUBE_GAP);
        posBottomTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBottom = new Rectangle(posBottomTube.x, posBottomTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x) {
        posTopTube.set(x, random.nextInt(FLUCTUATION) + LOWEST_OPENING + TUBE_GAP);
        posBottomTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(x, posTopTube.y);
        boundsBottom.setPosition(x, posBottomTube.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsBottom) || player.overlaps(boundsTop);
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }
}
