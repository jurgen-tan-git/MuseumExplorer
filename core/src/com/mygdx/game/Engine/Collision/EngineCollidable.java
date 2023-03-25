package com.mygdx.game.Engine.Collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Engine.Entity.SpriteObject;

public class EngineCollidable extends EngineCollisionMgt implements iCollidable{

    public boolean isColliding(SpriteObject sprite1, SpriteObject sprite2) {
        Rectangle bounds1 = sprite1.getBounds();
        Rectangle bounds2 = sprite2.getBounds();
        // Check if the rectangles representing the sprites intersect
        return bounds1.overlaps(bounds2);
    }
    public boolean polygonColliding(SpriteObject sprite1, SpriteObject sprite2) {
        // Get the polygon boundaries of the sprites
        Polygon polygon1 = sprite1.getPolygonBoundary();
        Polygon polygon2 = sprite2.getPolygonBoundary();

        // Check if the polygons intersect
        return Intersector.overlapConvexPolygons(polygon1, polygon2);
    }



    @Override
    public boolean reactCollision(SpriteObject sprite1, SpriteObject sprite2) {
        return false;
    }

    public boolean detectBorderCollision(SpriteObject sprite1, int screenWidth, int screenHeight) {
        // Check if the sprite is outside the screen bounds
        if (sprite1.getX() < 0 || sprite1.getY() < 0 || sprite1.getX() + sprite1.getBounds().getWidth() > screenWidth || sprite1.getY() + sprite1.getBounds().getHeight() > screenHeight) {
            return true; // Collision detected
        } else {
            return false; // No collision detected
        }
    }

    public void handleBorderCollision(SpriteObject sprite, int screenWidth, int screenHeight) {
        // Get the sprite bounds
        Rectangle bounds = sprite.getBounds();
//        System.out.println(bounds.getX() + bounds.getWidth());

        // Check if the sprite is outside the screen bounds
        boolean isColliding = detectBorderCollision(sprite, screenWidth, screenHeight);

        if (isColliding) {
            // Calculate the displacement vector between the sprite and the screen border
            float dx = 0, dy = 0;

            if (bounds.getX() < 0) {
                dx = -bounds.getX();
            } else if (bounds.getX() + bounds.getWidth() > screenWidth) {
                dx = screenWidth - (bounds.getX() + bounds.getWidth());
            }

            if (bounds.getY() < 0) {
                dy = -bounds.getY();
            } else if (bounds.getY() + bounds.getHeight() > screenHeight) {
                dy = screenHeight - (bounds.getY() + bounds.getHeight());
            }

            // Move the sprite to the closest position inside the screen bounds
            sprite.setPosition(sprite.getX() + dx, sprite.getY() + dy);
        }
    }


    }


