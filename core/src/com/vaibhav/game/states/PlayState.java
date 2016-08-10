package com.vaibhav.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.vaibhav.game.MyGdxGame;
import com.vaibhav.game.sprites.Bird;
import com.vaibhav.game.sprites.Tube;

/**
 * Created by vaibhav on 5/8/16.
 */
public class PlayState extends State {

    private Bird bird;
    private Texture background;
    private final static int TUBE_SPACING = 100;
    private static final int TUBE_COUNT = 4;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        background = new Texture("bg.png");
        tubes = new Array<Tube>();
        for (int i = 1; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }


    }

    @Override
    protected void handleInput() {

        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bird.update(deltaTime);
        camera.position.x = bird.getPosition().x + 100;

        for (Tube tube : tubes) {
            if (camera.position.x - camera.viewportWidth / 2 > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if (tube.collides(bird.getBounds())) {
                gsm.setState(new MenuState(gsm));
            }

        }
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            spriteBatch.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        }

        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }
}
