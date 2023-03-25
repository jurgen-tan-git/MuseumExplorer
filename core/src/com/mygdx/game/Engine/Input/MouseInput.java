package com.mygdx.game.Engine.Input;

import com.badlogic.gdx.Gdx;

public class MouseInput {
    private InputMgt input;

    public MouseInput(InputMgt input) {
        this.input = input;
    }

    public boolean isMouseClicked() {
        return Gdx.input.justTouched();
    }

    public int getMouseX() {
        return Gdx.input.getX();
    }

    public int getMouseY() {
        return Gdx.graphics.getHeight() - Gdx.input.getY();
    }
}

