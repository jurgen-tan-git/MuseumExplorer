package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class MovableObject extends EngineEntityMgt {

    private int Score;

    //Write a constructor that creates a movableObject
    public MovableObject(int objHP, int coord_x, int coord_y, boolean alive, Color color, Texture tp, int Score){
        super(objHP, coord_x, coord_y, alive, color, tp);
        this.Score = Score;
    }

    public MovableObject() {

    }

}