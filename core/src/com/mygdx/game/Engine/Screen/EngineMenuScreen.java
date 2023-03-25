package com.mygdx.game.Engine.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public abstract class EngineMenuScreen extends EngineScreenMgt {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private BitmapFont font = new BitmapFont(Gdx.files.internal("chibold.fnt"));
    private GlyphLayout layout = new GlyphLayout();


    @Override
    public abstract void show();


    @Override
    public abstract void render(float delta);
}

