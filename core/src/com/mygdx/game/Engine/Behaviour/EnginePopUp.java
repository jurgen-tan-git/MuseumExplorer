package com.mygdx.game.Engine.Behaviour;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

public abstract class EnginePopUp {
    private static Stage stage;
    private static Skin skin;
    private Dialog dialog;
    int currentQuestionIndex = 0;
    boolean isPaused = false;
    private Array<XmlReader.Element> questions;
    private TextButton button;
    private TextButton button1;
    private int score = 0;



    public abstract void createPopup();

    public abstract int getScore();

    public abstract int resetScore();
    public abstract boolean getIsPaused();

    public abstract void renderPopup();
    public abstract void showDialog();

    public abstract void dispose();
}
