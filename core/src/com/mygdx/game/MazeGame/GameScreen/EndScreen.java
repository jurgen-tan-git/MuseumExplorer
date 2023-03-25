package com.mygdx.game.MazeGame.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.mygdx.game.Engine.Screen.EngineEndScreen;


public class EndScreen extends EngineEndScreen {

    private Stage stage;
    private Skin skin;
    private Label scoreLabel;
    private boolean restartClicked = false;
    private boolean menuClicked = false;
    private String endtext;
    private String buttontext;
    private int score;
    private long start;
    public long end;


    public EndScreen(String endtext, String buttontext) {
        this.endtext = endtext;
        this.buttontext = buttontext;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));

        scoreLabel = new Label("Score: 0", skin, "default");
        scoreLabel.setPosition(20, Gdx.graphics.getHeight() - 50);
        stage.addActor(scoreLabel);

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        // create the end game message label
        Label endGameLabel = new Label(endtext, skin, "title");
        endGameLabel.setPosition(Gdx.graphics.getWidth() / 2f - endGameLabel.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        endGameLabel.setWidth(Gdx.graphics.getWidth()/5f);
        // create the restart button
        TextButton restartButton = new TextButton(buttontext, skin, "default");
        restartButton.setSize(200f, 60f);
        restartButton.setPosition(Gdx.graphics.getWidth() / 2f - restartButton.getWidth() / 2f, endGameLabel.getY() - 80f);
        restartButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                // restart the game
                restartClicked = true;

            }
        });

        // create the main menu button
        TextButton mainMenuButton = new TextButton("Menu", skin, "default");
        mainMenuButton.setSize(200f, 60f);
        mainMenuButton.setPosition(Gdx.graphics.getWidth() / 2f - mainMenuButton.getWidth() / 2f, restartButton.getY() - 80f);
        mainMenuButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                // return to the main menu
                menuClicked = true;
            }
        });

        TextButton quitButton = new TextButton("Quit", skin, "default");
        quitButton.setSize(200f, 60f);
        quitButton.setPosition(Gdx.graphics.getWidth() / 2f - quitButton.getWidth() / 2f, mainMenuButton.getY() - 80f);
        quitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                // return to the main menu
                quit();
            }
        });
// add the end game message label and buttons to the stage
        stage.addActor(endGameLabel);
        stage.addActor(restartButton);
        stage.addActor(mainMenuButton);
        stage.addActor(quitButton);
    }

    public void reset(){
        show();
    }

    @Override
    public void render(float delta) {
        clear();
        scoreLabel.setText("Score: " + score);
        stage.act();
        stage.draw();

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();

    }


    public boolean getmenuClicked() {
        return menuClicked;
    }

    public void resetmenuClicked(){
        menuClicked = false;
    }

    public void resetRestartClicked(){
        restartClicked = false;
    }
    public void setScore(int x, int time){
        score= 1000 + (100 * x) - (10 * (100-time));
    }
    public int getScore(){
        return score;
    }

    public boolean getrestartClicked() {
        return restartClicked;
    }


    public void setStart(long time){
        start = time;
    }
    public void setEnd(long time){
        end = time;
    }
}

