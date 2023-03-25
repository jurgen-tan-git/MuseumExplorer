package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class SpriteObject {
    private Texture texture;
    private Sprite sprite;
    private float x;
    private float y;
    private int speed;
    private Rectangle bounds;
    private Polygon polygonBoundary;


    public SpriteObject(String texturePath, float x, float y) {
        // Load the texture from the specified path
        texture = new Texture(Gdx.files.internal(texturePath));
        sprite = new Sprite(texture);
        this.x = x;
        this.y = y;
        this.speed = 1;
        this.bounds = new Rectangle(x, y, sprite.getWidth() * sprite.getScaleX(), sprite.getHeight() * sprite.getScaleY());
        // Create a default rectangular polygon boundary
        float[] vertices = {0, 0, sprite.getWidth(), 0, sprite.getWidth(), sprite.getHeight(), 0, sprite.getHeight()};
        polygonBoundary = new Polygon(vertices);
    }
    public SpriteObject(String texturePath) {
        // Load the texture from the specified path
        texture = new Texture(Gdx.files.internal(texturePath));
        sprite = new Sprite(texture);
        this.bounds = new Rectangle(x, y, sprite.getWidth() * sprite.getScaleX(), sprite.getHeight() * sprite.getScaleY());
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(x, y);
        sprite.draw(spriteBatch);
    }

    public void draw(SpriteBatch spriteBatch, float size) {
        spriteBatch.draw(sprite, x, y, size, size);
    }

    public void setScale(float scale) {
        sprite.setScale(scale);
        bounds.setWidth(sprite.getWidth() * sprite.getScaleX());
        bounds.setHeight(sprite.getHeight() * sprite.getScaleY());
    }

    public Sprite getSprite() {
        return sprite;
    }
    public void dispose() {
        texture.dispose();
    }

    public void move(float deltaX, float deltaY) {
        x += deltaX * speed;
        y += deltaY * speed;
        bounds.setPosition(x, y);
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }


    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        bounds.setPosition(x, y);
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        this.x = bounds.x;
        this.y = bounds.y;
        sprite.setSize(bounds.getWidth() / sprite.getScaleX(), bounds.getHeight() / sprite.getScaleY());
    }

    public Polygon getPolygonBoundary() {
        return polygonBoundary;
    }

    public void createPolygonBoundary() {
        float[] vertices = {0, 0, sprite.getWidth(), 0, sprite.getWidth(), sprite.getHeight(), 0, sprite.getHeight()};
        polygonBoundary = new Polygon(vertices);
        polygonBoundary.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        polygonBoundary.setPosition(sprite.getX(), sprite.getY());
        polygonBoundary.setScale(sprite.getScaleX(), sprite.getScaleY());
        polygonBoundary.setRotation(sprite.getRotation());
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public float getX() {    return x;
    }
    public float getY() {    return y;
    }
}

