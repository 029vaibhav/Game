package com.vaibhav.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by vaibhav on 5/8/16.
 */
public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;


    public State(GameStateManager gameStateManager) {
        this.camera = new OrthographicCamera();
        mouse = new Vector3();
        gsm = gameStateManager;
    }

    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();

}
