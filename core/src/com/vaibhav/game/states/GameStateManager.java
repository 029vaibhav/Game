package com.vaibhav.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by vaibhav on 5/8/16.
 */
public class GameStateManager {

    private Stack<State> stateStack;

    public GameStateManager() {
        this.stateStack = new Stack<State>();
    }

    public void push(State state) {
        stateStack.push(state);
    }

    public void pop() {
        stateStack.pop().dispose();
    }

    public void setState(State state) {
        pop();
        push(state);
    }

    public void update(float deltaTime) {
        stateStack.peek().update(deltaTime);
    }

    public void render(SpriteBatch spriteBatch) {
        stateStack.peek().render(spriteBatch);
    }
}
