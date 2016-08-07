package com.vaibhav.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vaibhav.game.MyGdxGame;

/**
 * Created by vaibhav on 5/8/16.
 */
public class PlayState extends State {

    private Texture bird;


    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Texture("bird.png");
        camera.setToOrtho(false,MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bird, 50,50);
        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }
}
