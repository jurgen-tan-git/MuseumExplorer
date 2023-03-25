package com.mygdx.game.Engine.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.SoundEffect.EngineMusic;
import com.mygdx.game.MazeGame.GameScreen.GameScreen;


public abstract class EngineScreenMgt implements Screen, iScreen {
    private static Texture renderTexture;
    private static Sprite renderSprite;
    private SpriteBatch batch;

    private String textureName;
    private iScreen[] screens;


    public iScreen[] createScreens(){
        return new EngineScreenMgt[]{};
    };


    public long getTime(){
        return System.nanoTime();
    }

    public void newGame(){
        screens[2] = new GameScreen();
    }


    public static void clear(){
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    public static void quit(){
            Gdx.app.exit();
            System.exit(0);
    }

    public static void loadTextures(String textureName){
            renderTexture = new Texture(textureName);
            renderSprite = new Sprite(renderTexture);

        }
    public String getTextureName(){
        return textureName;
    }

    public void setTextureName(String textureName){
        this.textureName = textureName;
    }

    public void renderTexture(){
        batch.begin();
        renderSprite.draw(batch);
        batch.end();
    }

    public int yBoundary(int y){
        int maxY = Gdx.graphics.getHeight();
        if (y < 0) {
            // Player is trying to move too far down, so set their position to the boundary
            y = 0;
        }
        if (y > maxY) {
            // Player is trying to move too far up, so set their position to the boundary
            y = maxY;
        }
        return y;
    }
    public int xBoundary(int x){
        int maxX = Gdx.graphics.getWidth();



        if (x < 0) {
            // Player is trying to move too far left, so set their position to the boundary
            x = 0;
        }
        if (x > maxX) {
            // Player is trying to move too far right, so set their position to the boundary
            x = maxX;
        }
        return x;
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}

