package com.mygdx.game.MazeGame.GameCollidable;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Engine.Collision.EngineCollidable;
import com.mygdx.game.Engine.Entity.SpriteObject;

public class GameCollidable extends EngineCollidable {
    public boolean reactCollision(SpriteObject sprite1, SpriteObject sprite2) {
        Rectangle bounds1 = sprite1.getBounds();
        Rectangle bounds2 = sprite2.getBounds();

        // Check if the rectangles representing the sprites intersect
        boolean isColliding = bounds1.overlaps(bounds2);

        if (isColliding) {
            // Calculate the displacement vector between the two sprites
            float dx = bounds2.x - bounds1.x;
            float dy = bounds2.y - bounds1.y;

            // Adjust the position of the sprites so that they don't overlap
            if (Math.abs(dx) > Math.abs(dy)) {
                // Horizontal collision
                if (dx > 0) {
                    sprite1.setPosition(bounds2.x - bounds1.width, sprite1.getY());
                } else {
                    sprite1.setPosition(bounds2.x + bounds2.width, sprite1.getY());
                }
            } else {
                // Vertical collision
                if (dy > 0) {
                    sprite1.setPosition(sprite1.getX(), bounds2.y - bounds1.height);
                } else {
                    sprite1.setPosition(sprite1.getX(), bounds2.y + bounds2.height);
                }
            }
        }

        return isColliding;
    }
}
