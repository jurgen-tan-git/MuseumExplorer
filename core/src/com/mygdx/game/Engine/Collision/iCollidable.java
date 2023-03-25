package com.mygdx.game.Engine.Collision;

import com.mygdx.game.Engine.Entity.SpriteObject;

public interface iCollidable {
    boolean isColliding(SpriteObject sprite1, SpriteObject sprite2);
    boolean reactCollision(SpriteObject sprite1, SpriteObject sprite2);
    boolean detectBorderCollision(SpriteObject sprite1, int screenWidth, int screenHeight);
    void handleBorderCollision(SpriteObject sprite, int screenWidth, int screenHeight);

}
