package com.mygdx.game.MazeGame.GameEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Entity.SpriteObject;
import com.mygdx.game.Engine.Entity.Obstacle;

public class Wall extends Obstacle {
    private SpriteObject wallTexture;

public Wall(){;
    wallTexture = new SpriteObject("wall.png");
}



    public SpriteObject getWallTexture() {
        return wallTexture;
    }
}
