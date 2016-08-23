package com.vaibhav.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vaibhav.game.MyGdxGame;

/**
 * Created by vaibhav on 5/8/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;


    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.setState(new PlayState(gsm));
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        spriteBatch.draw(playBtn, (MyGdxGame.WIDTH / 2 - playBtn.getWidth() / 2), (MyGdxGame.HEIGHT / 2 - playBtn.getHeight() / 2));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
