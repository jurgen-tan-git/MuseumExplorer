package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Obstacle extends EngineEntityMgt {

    private int size;
    private int points;
    private SpriteObject wallTexture;

    //Write a constructor for obstacle with ArrayList<parentEntity> entityList as one of the arguments
    public Obstacle(int objHP, int coord_x, int coord_y, boolean alive, Color color, Texture tp, int s, int p) {
        super(objHP, coord_x, coord_y, alive, color, tp);
        this.size = s;
        this.points = p;

    }

    public Obstacle() {

    }




}