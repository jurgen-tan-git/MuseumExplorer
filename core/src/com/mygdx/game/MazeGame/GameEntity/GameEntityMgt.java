package com.mygdx.game.MazeGame.GameEntity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Entity.Player;
import com.mygdx.game.MazeGame.GameCollidable.GameCollisionMgt;
import com.mygdx.game.MazeGame.GameEntity.MazeRender;
import com.mygdx.game.Engine.Entity.EngineEntityMgt;
import com.mygdx.game.Engine.Entity.*;
import com.mygdx.game.MazeGame.GameScreen.ScreenMgt;

import java.util.ArrayList;


public class GameEntityMgt extends EngineEntityMgt {

    private static GameEntityMgt gameEntityMgt = null;
    private MazeRender mazeRender;
    private Player player;
    private SpriteBatch batch;


    protected GameEntityMgt() {
        batch = new SpriteBatch();
    }

    public static GameEntityMgt getInstance(){
        if (gameEntityMgt == null){
            gameEntityMgt = new GameEntityMgt() {
            };
        }
        return gameEntityMgt;
    }


    public MazeRender getMazeRender() {
        return mazeRender;
    }

    public void createMazeRender() {
        mazeRender = mazeRender = new MazeRender(batch);
    }

    //Players
    public Player createPlayer(){
        player = new Player(mazeRender.getX(), mazeRender.getY());
        return player;
    }


    @Override
    public void create(){}
    @Override
    public void initialise(){}
    @Override
    public void load(){}
    @Override
    public void draw(){}
    @Override
    public void update(){}
    @Override
    public void dispose(){}
    @Override
    public void render(){}
}
