package com.mygdx.game.MazeGame.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Engine.Screen.EngineGameScreen;

public class GameScreen extends EngineGameScreen {
    private Stage stage;
    private OrthographicCamera camera;
    public GameScreen(){
    }
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 30);

    }
    public void update() {
    }

    @Override
    public void dispose(){
        super.dispose();
        stage.dispose();
    }


}
