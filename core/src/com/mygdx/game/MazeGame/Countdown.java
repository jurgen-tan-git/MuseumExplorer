package com.mygdx.game.MazeGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.Timer;
import java.util.TimerTask;

public final class Countdown {
    private int count;
    private SpriteBatch batch = new SpriteBatch();
    private BitmapFont font = new BitmapFont(Gdx.files.internal("chibold.fnt"));
    private GlyphLayout layout = new GlyphLayout();
    private Stage stage;
    private Label timeLabel;
    private Skin skin;
    private static Countdown instance = null;
    private boolean isPaused;


    private Countdown() {
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        timeLabel = new Label(null, skin, "default");
        timeLabel.setPosition(Gdx.graphics.getWidth() / 4f - 45, Gdx.graphics.getHeight()/2f - timeLabel.getHeight());
        timeLabel.setColor(202/255f,192/255f,153/255f,0.3f);
        timeLabel.setFontScale(10f);
        stage.addActor(timeLabel);


        count = 100;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(isPaused == false) {
                    count--;
                }
            }
        };

        timer.schedule(task, 0, 1000); // Schedule the task to run every 1 minute (60,000ms)

    }

    public static Countdown getInstance(){
        if(instance == null){
            instance = new Countdown();
        }
        return instance;
    }

    public void createCountDown(){
        instance = new Countdown();
    }
    public int getTime(){
        return count;
    }

    public void render(){
        if (count <= 9){
            timeLabel.setText("0" + count);
        }
        else{
            timeLabel.setText(count);
        }
        timeLabel.setScale(100f);
        stage.act();
        stage.draw();
    }
    public void setIsPaused(boolean isPaused){
        this.isPaused = isPaused;
    }

}

