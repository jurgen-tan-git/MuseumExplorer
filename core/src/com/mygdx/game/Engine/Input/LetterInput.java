package com.mygdx.game.Engine.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class LetterInput {
    private InputMgt input;

    public LetterInput(InputMgt input) {
        this.input = input;
    }

    public boolean isLetterPressed(String letter) {
        input.setKeycode(Input.Keys.valueOf(letter));
        return input.getKeycode() == Input.Keys.valueOf(letter);
    }

    public boolean isEscapePressed(){
        return Gdx.input.isKeyPressed(Input.Keys.ESCAPE);
    }

    public boolean isSpacePressed(){
        return Gdx.input.isKeyPressed(Input.Keys.SPACE);
    }




}

