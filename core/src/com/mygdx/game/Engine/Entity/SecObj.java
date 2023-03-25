package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SecObj extends EngineEntityMgt {

    private int length, width;

    //Write a constructor for secObj
    public SecObj(int objHP, int coord_x, int coord_y, boolean alive, Color color, Texture tp, int length, int width){
        super(objHP, coord_x, coord_y, alive, color, tp);
        this.length = length;
        this.width = width;
    }

    public SecObj() {
        }


}