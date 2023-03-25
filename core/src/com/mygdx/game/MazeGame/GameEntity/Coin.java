package com.mygdx.game.MazeGame.GameEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Entity.SpriteObject;
import com.mygdx.game.Engine.Entity.SecObj;

public class Coin extends SecObj {
    private SpriteObject coinTexture;
    public Coin(){
        coinTexture = new SpriteObject("coin.png");
    }

    public SpriteObject getCoinTexture() {
        return coinTexture;
    }
}
