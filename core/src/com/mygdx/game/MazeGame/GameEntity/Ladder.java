package com.mygdx.game.MazeGame.GameEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Entity.SpriteObject;
import com.mygdx.game.Engine.Entity.SecObj;

public class Ladder extends SecObj {
    private SpriteObject ladderTexture;
    public Ladder(){
        ladderTexture = new SpriteObject("ladder.png");
    }

    public SpriteObject getLadderTexture() {
        return ladderTexture;
    }
}
