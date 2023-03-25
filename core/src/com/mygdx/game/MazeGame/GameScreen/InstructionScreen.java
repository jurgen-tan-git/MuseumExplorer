package com.mygdx.game.MazeGame.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Engine.Screen.EngineGameScreen;
import com.mygdx.game.Engine.Screen.EngineInstructionScreen;
import com.mygdx.game.Engine.Screen.EngineScreenMgt;

public class InstructionScreen extends EngineInstructionScreen {

    private Stage stage;
    private Skin skin;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private float x;
    private float y;



    public InstructionScreen() {

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        map = new TmxMapLoader().load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 16f);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 30);


    }
    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);
        // crete the end game message label
        Label gametitleLabel = new Label("Museum Explorer", skin, "title");
        gametitleLabel.setPosition(80, 500);
        gametitleLabel.setFontScale(0.5F);
        gametitleLabel.setWidth(Gdx.graphics.getWidth()/5f);


        Label objectiveLabel = new Label("Objective: Complete the maze within 100 seconds!!", skin, "default");
        objectiveLabel.setPosition(60, 450);
        objectiveLabel.setWrap(true);
        objectiveLabel.setFontScale(0.8F);
        objectiveLabel.setWidth(Gdx.graphics.getWidth()/1.2f);

        Label howToPlayLabel = new Label("How to Play: Use arrow keys to move", skin, "default");
        howToPlayLabel.setPosition(60, 370);
        howToPlayLabel.setWrap(true);
        howToPlayLabel.setFontScale(0.8F);
        howToPlayLabel.setWidth(Gdx.graphics.getWidth()/1.2f);

        Label explainLabel = new Label("You will begin with 1000 points - you will earn points as you solve questions!", skin, "default");
        explainLabel.setPosition(60, 270);
        explainLabel.setWrap(true);
        explainLabel.setFontScale(0.8F);
        explainLabel.setWidth(Gdx.graphics.getWidth()/1.2f);

        Label presskeyLabel = new Label("Press SPACEBAR to continue!", skin, "default");
        presskeyLabel.setPosition(110, 70);
        presskeyLabel.setWrap(true);
        presskeyLabel.setFontScale(0.8F);
        presskeyLabel.setWidth(Gdx.graphics.getWidth()/1.2f);



        stage.addActor(gametitleLabel);
        stage.addActor(objectiveLabel);
        stage.addActor(howToPlayLabel);
        stage.addActor(explainLabel);
        stage.addActor(presskeyLabel);

    }

    public void render(float delta) {
        renderer.setView(camera);
        renderer.render();

        y = Gdx.graphics.getHeight();
        stage.act();
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();

    }
}