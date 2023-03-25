package com.mygdx.game.Engine.Collision;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Engine.Entity.SpriteObject;

public class EngineNonCollidable extends EngineCollisionMgt{


    public void update(float deltaTime) {
        // do nothing, since this is a non-collidable object
    }

    public boolean detectCollision(iCollidable other) {
        // this is a non-collidable object, so it can't collide with anything
        return false;
    }

    public boolean reactCollision(iCollidable other) {
        // this is a non-collidable object, so it can't collide with anything
        return false;
    }

}
