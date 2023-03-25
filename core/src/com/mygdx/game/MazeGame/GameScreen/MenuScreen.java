package com.mygdx.game.MazeGame.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Engine.Screen.EngineMenuScreen;

public class MenuScreen extends EngineMenuScreen {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private BitmapFont font = new BitmapFont(Gdx.files.internal("chibold.fnt"));
    private GlyphLayout layout = new GlyphLayout();

    private SpriteBatch batch;
    private float x;
    private float y;

    public MenuScreen() {
       batch = new SpriteBatch();

    };

    @Override
    public void show() {
        map = new TmxMapLoader().load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / 16f);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 30);

    }

    @Override
    public void render(float delta) {
        clear();
        renderer.setView(camera);
        renderer.render();


        y = Gdx.graphics.getHeight();
        batch.begin();


        font.getData().setScale(2.0f);
        layout.setText(font, "Museum Explorer");
        x = Gdx.graphics.getWidth() / 2 - layout.width / 2;
        font.getData().setScale(2.0f);
        font.setColor(new Color(188f/255f,173f/255f,152f/255f,255f/255f));
//        System.out.println("Drawing");
        font.draw(batch, "Museum Explorer", x, y * 3 / 4);

        font.getData().setScale(1.0f);
        font.setColor(new Color(99f/255f,75/255f,35f/255f,255f/255f));
        layout.setText(font, "Click ANYWHERE to start the game");
        x = Gdx.graphics.getWidth() / 2 - layout.width / 2;
        font.draw(batch, "Click ANYWHERE to start the game", x, y / 3);
        batch.end();
    }

}
