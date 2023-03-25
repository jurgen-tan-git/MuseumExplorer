package com.mygdx.game.Engine.Input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


public final class InputMgt implements InputProcessor {
    private int keycode;
    private MouseInput mouseInput;
    private ArrowInput arrowInput;
    private LetterInput letterInput;
    private static InputMgt inputMgt = null;


    protected InputMgt(){
        arrowInput = new ArrowInput(this);
        letterInput = new LetterInput(this);
        mouseInput = new MouseInput(this);
    }

    public static InputMgt getInstance() {
        if(inputMgt == null){
            inputMgt = new InputMgt();
        }
        return inputMgt;
    }

    public int getKeycode() {
        return keycode;
    }
    protected void setKeycode(int keycode){
        this.keycode = keycode;
    }

    public void resetKeycode(){
        keycode = 0;
    }
    public ArrowInput getArrowInput() {
        return arrowInput;
    }

    public LetterInput getLetterInput() {
        return letterInput;
    }

    public MouseInput getMouseInput() {
        return mouseInput;
    }

    @Override
    public boolean keyDown(int keycode) {
        this.keycode = keycode;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        this.keycode = 0;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

