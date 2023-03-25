package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends MovableObject {
private SpriteObject player;

public Player(int x, int y){
    player = new SpriteObject("DinoSprites_tard.gif", x ,y);
    }

    public SpriteObject getPlayer() {
        return player;
    }
}
