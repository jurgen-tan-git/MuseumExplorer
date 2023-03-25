package com.mygdx.game.Engine.Input;

import com.badlogic.gdx.Input;

public class ArrowInput {
    private InputMgt input;

    public ArrowInput(InputMgt input) {
        this.input = input;
    }

    public boolean isLeftPressed() {
        return (input.getKeycode() == Input.Keys.LEFT) ;
    }

    public boolean isRightPressed() {
        return (input.getKeycode() == Input.Keys.RIGHT);
    }

    public boolean isUpPressed() {
        return (input.getKeycode() == Input.Keys.UP);
    }

    public boolean isDownPressed() {
        return (input.getKeycode() == Input.Keys.DOWN);
    }
}

