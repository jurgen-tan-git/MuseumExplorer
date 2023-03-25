package com.mygdx.game.MazeGame.GameEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Entity.SpriteObject;
import com.mygdx.game.Engine.Entity.SecObj;

public class Floor extends SecObj {
    private SpriteObject floorTexture;
    public Floor(){
        floorTexture = new SpriteObject("floor.png");
    }

    public SpriteObject getFloorTexture() {
        return floorTexture;
    }
}
